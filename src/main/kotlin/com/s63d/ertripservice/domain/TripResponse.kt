package com.s63d.ertripservice.domain

import kotlin.math.roundToInt

data class TripResponse (val tripId: Long, val length: Int, val polyline: String) {
    companion object {
        private fun computePolyline(locations: Iterable<Location>) : String {
            return ""
        }

        private fun computeLength(locations: List<Location>) : Int {
            var sum = 0
            for (i in 0 until locations.size - 1) {
                sum += distFrom(locations[i], locations[i + 1]).roundToInt()
            }
            return sum
        }

        private fun distFrom(loc1: Location, loc2: Location): Float {
            val earthRadius = 6371000.0 //meters
            val dLat = Math.toRadians(loc2.lat - loc1.lat)
            val dLng = Math.toRadians(loc2.lon - loc1.lon)
            val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(loc1.lat)) * Math.cos(Math.toRadians(loc2.lat)) *
                    Math.sin(dLng / 2) * Math.sin(dLng / 2)
            val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))

            return (earthRadius * c).toFloat()
        }
    }
    constructor(trip: Trip) : this(trip.id, computeLength(trip.locations), computePolyline(trip.locations))
}