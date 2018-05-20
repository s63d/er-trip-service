package com.s63d.ervehicleservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class ErTripServiceApplication

fun main(args: Array<String>) {
    runApplication<ErTripServiceApplication>(*args)
}
