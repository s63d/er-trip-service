package com.s63d.ertripservice.domain.db

import com.fasterxml.jackson.annotation.JsonAlias
import javax.persistence.Embeddable

@Embeddable
data class CarTracker(@JsonAlias("id") val carTrackerId: String)