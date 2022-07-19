package com.dzakdzaks.ojekapi.user.entity

import com.dzakdzaks.ojekapi.location.entity.Coordinate

data class UserRegister(
    var username: String,
    var password: String
) {
    fun toUser(role: String): User {
        return User(
            username = username,
            password = password,
            role = role,
            location = Coordinate(0.0, 0.0)
        )
    }
}