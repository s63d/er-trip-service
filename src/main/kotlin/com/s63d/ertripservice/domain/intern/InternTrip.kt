package com.s63d.ertripservice.domain.intern

import com.s63d.ertripservice.domain.db.Trip
import com.s63d.ertripservice.domain.db.toPolyline
import com.s63d.ertripservice.domain.rest.SimpleVehicle

data class InternTrip(val id: Long, val polyline: String, val vehicleWeight: Int) {

    private constructor() : this(0, "", 0)

    constructor(trip:Trip, vehicle: SimpleVehicle) : this(trip.id, trip.locations.toPolyline(), vehicle.weight)

}