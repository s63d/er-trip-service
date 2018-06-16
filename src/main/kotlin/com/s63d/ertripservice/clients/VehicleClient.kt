package com.s63d.ertripservice.clients

import com.s63d.ertripservice.domain.rest.SimpleVehicle
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.HttpHeaders
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient("vehicles", url = "\${urls.vehicle-service}/api")
@RequestMapping("/gov/vehicles")
interface VehicleClient {

    @GetMapping("{license}")
    fun getById(@PathVariable license: String, @RequestHeader(HttpHeaders.AUTHORIZATION) auth: String) : SimpleVehicle?

}