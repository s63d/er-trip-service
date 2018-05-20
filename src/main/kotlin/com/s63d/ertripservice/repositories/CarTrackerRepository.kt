package com.s63d.ertripservice.repositories

import com.s63d.ertripservice.domain.CarTracker
import org.springframework.data.repository.CrudRepository

interface CarTrackerRepository : CrudRepository<CarTracker, String>