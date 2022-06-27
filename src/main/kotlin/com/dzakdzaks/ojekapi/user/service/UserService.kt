package com.dzakdzaks.ojekapi.user.service

import com.dzakdzaks.ojekapi.user.entity.*

interface UserService {
    fun register(userRegister: UserRegister, role: String): Result<Boolean>
    fun login(userLogin: UserLogin): Result<LoginResponse>
    fun getUserById(id: String): Result<UserResponse>
    fun getUserByUsername(username: String): Result<UserResponse>
}