package com.s63d.ertripservice.controllers

import com.s63d.ertripservice.services.TripService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/trips")
class TripController(private val tripService: TripService) {

    @PostMapping
    fun createNew(@RequestParam carTrackerId: String) = tripService.createNew(carTrackerId)

}