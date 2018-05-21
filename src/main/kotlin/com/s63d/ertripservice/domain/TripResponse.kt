package com.s63d.ertripservice.domain

import java.util.*

data class TripResponse (val tripId: Long, val length: Int, val polyline: String, val date: Date, val carTrackerId: String) {
    constructor(trip: Trip) : this(trip.id, trip.locations.totalLength, trip.locations.toPolyline(), trip.date, trip.carTracker.carTrackerId)
}