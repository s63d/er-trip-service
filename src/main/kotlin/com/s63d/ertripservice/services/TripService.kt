package com.s63d.ertripservice.services

import com.s63d.ertripservice.domain.CarTracker
import com.s63d.ertripservice.domain.Trip
import com.s63d.ertripservice.repositories.TripRepository
import org.springframework.stereotype.Service

@Service
class TripService(private val tripRepository: TripRepository) {

    fun createNew(carTrackerId: String) : Trip {
        val trip = Trip(CarTracker(carTrackerId))
        return tripRepository.save(trip)
    }

    fun byCarTracker(trackerId: String) = tripRepository.findByCarTrackerId(trackerId)

    fun byId(id: Long) = tripRepository.findById(id).orElseThrow { Exception("Invalid trip id") } // TODO response status

}