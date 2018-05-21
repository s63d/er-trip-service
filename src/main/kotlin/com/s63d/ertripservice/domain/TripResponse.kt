package com.s63d.ertripservice.domain

data class TripResponse (val tripId: Long, val length: Int, val polyline: String) {
    constructor(trip: Trip) : this(trip.id, trip.locations.totalLength, trip.locations.toPolyline())
}