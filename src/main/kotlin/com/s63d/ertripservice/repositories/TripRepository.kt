package com.s63d.ertripservice.repositories

import com.s63d.ertripservice.domain.db.Trip
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TripRepository : CrudRepository<Trip, Long> {

    @Query("SELECT t FROM Trip t WHERE t.carTracker.carTrackerId = ?1")
    fun findByCarTrackerId(carTrackerId: String) : List<Trip>
}