package com.s63d.ertripservice.domain.db

import java.util.*
import javax.persistence.*

@Entity
data class Trip(@Embedded val carTracker: CarTracker, val date: Date = Date(), @JoinColumn(name = "trip_id") @OneToMany val locations: List<Location> = mutableListOf(), @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id:Long = 0)