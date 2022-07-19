package com.dzakdzaks.ojekapi.util.ext

import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.util.entity.BaseResponse
import com.dzakdzaks.ojekapi.util.exception.ResponseException

inline fun <reified T> T?.orThrow(
    message: String = "${T::class.simpleName} is null"
): T {
    return this ?: throw ResponseException(message)
}

inline fun <reified T> T?.toResult(
    message: String = "${T::class.simpleName} is null"
): Result<T> {
    return if (this != null) {
        Result.success(this)
    } else {
        Result.failure(ResponseException(message))
    }
}

fun <T> Result<T>.toResponse(): BaseResponse<T> {
    return if (this.isFailure) {
        throw ResponseException(this.exceptionOrNull()?.message ?: "There is something error from response")
    } else {
        BaseResponse.success(this.getOrNull())
    }
}

fun String.toCoordinateData(): Coordinate {
    val coordinateStrings = split(",")
    val lat = coordinateStrings[0].toDoubleOrNull() ?: 0.0
    val lon = coordinateStrings[1].toDoubleOrNull() ?: 0.0
    return Coordinate(lat, lon)
}