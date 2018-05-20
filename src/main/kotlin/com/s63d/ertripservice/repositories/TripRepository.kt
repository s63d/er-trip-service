package com.s63d.ertripservice.repositories

import com.s63d.ertripservice.domain.Trip
import org.springframework.data.repository.CrudRepository

interface TripRepository : CrudRepository<Trip, Long>