package com.s63d.ertripservice.domain.rest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class SimpleVehicle(val carTrackerId: String? = null)