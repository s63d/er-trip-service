package com.s63d.ertripservice.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Location(val lat: Double, val lon: Double, @Id @GeneratedValue val id: Long = 0)