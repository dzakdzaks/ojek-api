package com.dzakdzaks.ojekapi.user.repository

import com.dzakdzaks.ojekapi.user.entity.User

interface UserRepository {
    fun createUser(user: User): Result<Boolean>
    fun getUserById(id: String): Result<User>
    fun getUserByUsername(username: String): Result<User>
}