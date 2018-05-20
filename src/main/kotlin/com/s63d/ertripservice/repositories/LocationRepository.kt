package com.s63d.ertripservice.repositories

import com.s63d.ertripservice.domain.Location
import org.springframework.data.repository.CrudRepository

interface LocationRepository : CrudRepository<Location, Long>