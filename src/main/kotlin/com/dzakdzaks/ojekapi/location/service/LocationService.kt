package com.dzakdzaks.ojekapi.location.service

import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.location.entity.Location
import com.dzakdzaks.ojekapi.location.entity.Routes

interface LocationService {
    fun searchLocation(name: String, coordinate: Coordinate, limit: String): Result<List<Location>>
    fun reserveLocation(coordinate: Coordinate): Result<Location>
    fun getRoutesLocation(origin: Coordinate, destination: Coordinate, transportMode: String): Result<Routes>
}