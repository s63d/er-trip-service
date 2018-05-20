package com.s63d.ertripservice.services

import com.s63d.ertripservice.domain.CarTracker
import com.s63d.ertripservice.domain.Trip
import com.s63d.ertripservice.repositories.TripRepository
import org.springframework.stereotype.Service

@Service
class TripService(private val tripRepository: TripRepository, private val carTrackerService: CarTrackerService) {

    fun createNew(carTrackerId: String) : Trip {
        val trip = Trip(CarTracker(carTrackerId))
        return tripRepository.save(trip)
    }

}