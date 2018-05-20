package com.s63d.ertripservice.domain

import com.fasterxml.jackson.annotation.JsonAlias
import javax.persistence.Embeddable

@Embeddable
data class CarTracker(@JsonAlias("id") val carTrackerId: String)