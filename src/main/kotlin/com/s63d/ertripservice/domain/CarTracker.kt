package com.s63d.ertripservice.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class CarTracker(@Id  val id: String = UUID.randomUUID().toString())