package com.s63d.ertripservice.domain

import it.rambow.master.javautils.Track
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import kotlin.math.roundToInt
import it.rambow.master.javautils.Trackpoint
import it.rambow.master.javautils.PolylineEncoder.createEncodings
import javax.persistence.GenerationType

@Entity
data class Location(val lat: Double, val lon: Double, @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0)

fun List<Location>.toPolyline() : String {

    val track = Track()

    track.trackpoints = ArrayList(this.map {
        Trackpoint(it.lat, it.lon)
    })

    return createEncodings(track, 17, 1)["encodedPoints"].toString()
}





val List<Location>.totalLength: Int
    get() {
        var sum = 0
        for (i in 0 until this.size - 1) {
            sum += distFrom(this[i], this[i + 1]).roundToInt()
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