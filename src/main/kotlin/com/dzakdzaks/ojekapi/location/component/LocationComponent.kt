package com.dzakdzaks.ojekapi.location.component

import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.location.entity.LocationHereApiResult
import com.dzakdzaks.ojekapi.location.entity.LocationHereRouteResult
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Component

@Component
class LocationComponent {

    private val client = OkHttpClient()

    private val hereApiKey = System.getenv("HERE_API_KEY")

    private inline fun <reified T> getHttp(url: String): Result<T> {
        return try {
            val request = Request.Builder()
                .url(url)
                .build()

            val response = client.newCall(request).execute()
            val body = response.body
            val bodyString = body?.string()

            if (response.isSuccessful && bodyString != null) {
                val data = ObjectMapper().readValue(bodyString, T::class.java)
                Result.success(data)
            } else {
                val throwable = IllegalArgumentException(response.message)
                Result.failure(throwable)
            }
        } catch (e: JsonParseException) {
            Result.failure(e)
        } catch (e: InvalidDefinitionException) {
            Result.failure(e)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }

    fun searchLocation(name: String, coordinate: Coordinate, limit: String): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = SEARCH_LOC
            .replace(Key.COORDINATE, coordinateString)
            .replace(Key.NAME, name)
            .replace(Key.LIMIT, limit)
            .replace(Key.HERE_API_KEY, hereApiKey)
        return getHttp(url)
    }

    fun reserveLocation(coordinate: Coordinate): Result<LocationHereApiResult> {
        val coordinateString = "${coordinate.latitude},${coordinate.longitude}"
        val url = RESERVE_LOC
            .replace(Key.COORDINATE, coordinateString)
            .replace(Key.HERE_API_KEY, hereApiKey)
        return getHttp(url)
    }

    /* Transport Mode
        pedestrian
        car
        truck
        bicycle
        scooter
    */
    fun getRoutes(origin: Coordinate, destination: Coordinate, transportMode: String): Result<LocationHereRouteResult> {
        val coordinateOriginString = "${origin.latitude},${origin.longitude}"
        val coordinateDestinationString = "${destination.latitude},${destination.longitude}"
        val url = ROUTES_POLYLINE_LOC
            .replace(Key.COORDINATE_ORIGIN, coordinateOriginString)
            .replace(Key.COORDINATE_DESTINATION, coordinateDestinationString)
            .replace(Key.TRANSPORT_MODE, transportMode)
            .replace(Key.HERE_API_KEY, hereApiKey)
        return getHttp(url)
    }

    companion object {
        const val SEARCH_LOC =
            "https://discover.search.hereapi.com/v1/discover?at={{coordinate}}&limit={{limit}}&q={{name}}&apiKey={{hereApiKey}}"
        const val RESERVE_LOC =
            "https://revgeocode.search.hereapi.com/v1/revgeocode?at={{coordinate}}&lang=en-US&apiKey={{hereApiKey}}"
        const val ROUTES_POLYLINE_LOC =
            "https://router.hereapi.com/v8/routes?transportMode={{transportMode}}&origin={{coordinate_origin}}&destination={{coordinate_destination}}&return=polyline&apikey={{hereApiKey}}"
    }

    object Key {
        const val COORDINATE = "{{coordinate}}"
        const val NAME = "{{name}}"
        const val LIMIT = "{{limit}}"
        const val TRANSPORT_MODE = "{{transportMode}}"
        const val HERE_API_KEY = "{{hereApiKey}}"

        const val COORDINATE_ORIGIN = "{{coordinate_origin}}"
        const val COORDINATE_DESTINATION = "{{coordinate_destination}}"
    }

}