package com.dzakdzaks.ojekapi.user.entity

data class UserRegister(
    var username: String,
    var password: String
) {
    fun toUser(role: String): User {
        return User(
            username = username,
            password = password,
            role = role
        )
    }
}