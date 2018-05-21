package com.s63d.ertripservice.domain

import kotlin.math.roundToInt

data class TripResponse (val tripId: Long, val length: Int, val polyline: String) {
    companion object {
        private fun computePolyline(locations: Iterable<Location>) : String {
            return ""
        }

    }
    constructor(trip: Trip) : this(trip.id, trip.locations.totalLength, trip.locations.toPolyline())
}