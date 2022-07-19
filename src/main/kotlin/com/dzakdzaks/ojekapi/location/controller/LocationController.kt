package com.dzakdzaks.ojekapi.location.controller

import com.dzakdzaks.ojekapi.location.entity.Location
import com.dzakdzaks.ojekapi.location.entity.Routes
import com.dzakdzaks.ojekapi.location.service.LocationService
import com.dzakdzaks.ojekapi.util.entity.BaseResponse
import com.dzakdzaks.ojekapi.util.ext.toCoordinateData
import com.dzakdzaks.ojekapi.util.ext.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(LocationController.PATH_BASE)
class LocationController {

    @Autowired
    private lateinit var locationService: LocationService

    @GetMapping(PATH_SEARCH)
    fun searchLocation(
        @RequestParam(value = "name") name: String,
        @RequestParam(value = "coordinate") coordinate: String,
        @RequestParam(value = "limit", required = false, defaultValue = "20") limit: String,
    ): BaseResponse<List<Location>> {
        val coordinateData = coordinate.toCoordinateData()
        return locationService.searchLocation(name, coordinateData, limit).toResponse()
    }

    @GetMapping(PATH_RESERVE)
    fun reserveLocation(
        @RequestParam(value = "coordinate") coordinate: String
    ): BaseResponse<Location> {
        val coordinateData = coordinate.toCoordinateData()
        return locationService.reserveLocation(coordinateData).toResponse()
    }

    @GetMapping(PATH_ROUTES)
    fun routesLocation(
        @RequestParam(value = "transportMode") transportMode: String,
        @RequestParam(value = "origin") origin: String,
        @RequestParam(value = "destination") destination: String
    ): BaseResponse<Routes> {
        val coordinateOrigin = origin.toCoordinateData()
        val coordinateDestination = destination.toCoordinateData()
        return locationService.getRoutesLocation(coordinateOrigin, coordinateDestination, transportMode).toResponse()
    }

    companion object {
        const val PATH_BASE = "/api/v1/location"
        const val PATH_SEARCH = "/search"
        const val PATH_RESERVE = "/reserve"
        const val PATH_ROUTES = "/routes"
    }
}