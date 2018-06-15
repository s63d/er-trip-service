package com.s63d.ertripservice.controllers

import com.s63d.ertripservice.services.TripService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/trips")
class TripController(private val tripService: TripService) {

    @PostMapping
    fun createNew(@RequestParam carTrackerId: String) = tripService.createNew(carTrackerId)

    @GetMapping
    fun getTripsForVehicle(@RequestParam vehicleId: String, principal: Principal) = tripService.byVehicleId(vehicleId)

    @PostMapping
    @RequestMapping("{id}/finished")
    fun finishTrip(@PathVariable id: Long) =  tripService.finishTrip(id)

}