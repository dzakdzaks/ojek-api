package com.dzakdzaks.ojekapi.location.entity

data class Location(
    var name: String = "",
    var address: Address = Address(),
    var coordinate: Coordinate = Coordinate()
) {
    data class Address(
        var city: String = "",
        var country: String = "",
        var distric: String = ""
    )
}