package com.dzakdzaks.ojekapi.user.entity

data class LoginResponse(
    val token: String,
    val user: UserResponse?
)
