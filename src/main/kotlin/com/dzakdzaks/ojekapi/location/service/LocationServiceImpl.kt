package com.dzakdzaks.ojekapi.location.service

import com.dzakdzaks.ojekapi.location.component.LocationComponent
import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.location.entity.Location
import com.dzakdzaks.ojekapi.location.entity.Routes
import com.dzakdzaks.ojekapi.location.mapper.Mapper
import com.dzakdzaks.ojekapi.util.ext.orThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LocationServiceImpl(
    @Autowired private val fetcher: LocationComponent
) : LocationService {
    override fun searchLocation(name: String, coordinate: Coordinate, limit: String): Result<List<Location>> {
        return fetcher.searchLocation(name, coordinate, limit).map {
            Mapper.mapSearchLocationHereToLocation(it)
        }
    }

    override fun reserveLocation(coordinate: Coordinate): Result<Location> {
        return fetcher.reserveLocation(coordinate).map {
            Mapper.mapSearchLocationHereToLocation(it).firstOrNull().orThrow("Location not found")
        }
    }

    override fun getRoutesLocation(origin: Coordinate, destination: Coordinate, transportMode: String): Result<Routes> {
        return fetcher.getRoutes(origin, destination, transportMode).map {
            Routes(Mapper.mapRoutesHereToRoutes(it))
        }
    }
}