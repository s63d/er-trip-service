package com.s63d.ertripservice.services

import com.s63d.ertripservice.clients.VehicleClient
import com.s63d.ertripservice.domain.db.CarTracker
import com.s63d.ertripservice.domain.db.Trip
import com.s63d.ertripservice.domain.intern.InternTrip
import com.s63d.ertripservice.domain.rest.TripResponse
import com.s63d.ertripservice.repositories.TripRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TripService(private val tripRepository: TripRepository, private val vehicleClient: VehicleClient, private val rabbitTemplate: RabbitTemplate) {

    fun createNew(carTrackerId: String) : Trip {
        val trip = Trip(CarTracker(carTrackerId))
        return tripRepository.save(trip).also(::println)
    }

    fun byCarTracker(trackerId: String?, pageable: Pageable = Pageable.unpaged()) = tripRepository.findByCarTrackerId(trackerId, pageable).map { TripResponse(it) }


    val user1 = " eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnb29zamVAaG90bWFpbC5jb20iLCJ1c2VyUm9sZSI6ImJhc2ljIiwidXNlcklkIjoxfQ.QPLlsebqlIdn6FQIMThrIQcNtk7qygStwyUcaxETXHQ"
    fun byVehicleId(id: String, pageable: Pageable = Pageable.unpaged()): Page<TripResponse> {
        val carTrackerId = vehicleClient.getById(id, user1)?.carTrackerId
        return byCarTracker(carTrackerId, pageable)
    }

    fun finishTrip(id: Long) {
        val trip = tripRepository.findById(id).orElseThrow { Exception("Trip '$id' not found") }
        val vehicle = vehicleClient.getById(trip.carTracker.carTrackerId, user1) ?: throw Exception("Car not found with car tracker ${trip.carTracker.carTrackerId}")
        val internTrip = InternTrip(trip, vehicle)
        rabbitTemplate.convertAndSend("AT", "trip", internTrip)
    }
}