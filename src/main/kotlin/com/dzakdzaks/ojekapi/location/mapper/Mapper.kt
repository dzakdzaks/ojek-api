package com.dzakdzaks.ojekapi.location.mapper

import com.dzakdzaks.ojekapi.PolylineEncoderDecoder
import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.location.entity.Location
import com.dzakdzaks.ojekapi.location.entity.LocationHereApiResult
import com.dzakdzaks.ojekapi.location.entity.LocationHereRouteResult

object Mapper {
    fun mapSearchLocationHereToLocation(locationResult: LocationHereApiResult): List<Location> {
        return locationResult.items?.map {
            val address = Location.Address(
                city = it?.address?.city.orEmpty(),
                country = it?.address?.countryName.orEmpty(),
                distric = it?.address?.district.orEmpty()
            )
            Location(
                name = it?.title.orEmpty(),
                address = address,
                coordinate = Coordinate(it?.position?.lat ?: 0.0, it?.position?.lng ?: 0.0)
            )
        }.orEmpty()
    }

    fun mapRoutesHereToRoutes(locationResult: LocationHereRouteResult): List<Coordinate> {
        val polylineString = locationResult.routes
            ?.firstOrNull()
            ?.sections
            ?.firstOrNull()
            ?.polyline
            .orEmpty()

        return PolylineEncoderDecoder.decode(polylineString)
            .map { Coordinate(it.lat, it.lng) }
    }
}