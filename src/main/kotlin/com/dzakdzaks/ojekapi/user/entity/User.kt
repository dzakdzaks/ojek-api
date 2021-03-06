package com.dzakdzaks.ojekapi.user.entity

import com.dzakdzaks.ojekapi.location.entity.Coordinate
import com.dzakdzaks.ojekapi.userRole.entity.UserRole
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.newId
import java.util.Date

data class User(
    @BsonId
    val id: String = newId<User>().toString(),
    var username: String,
    var password: String,
    var role: String,
    var createdDate: Date = Date(),
    var updatedDate: Date = Date(),
    var location: Coordinate? = null,
) {
    fun toResponseUser(userRole: UserRole?): UserResponse {
        return UserResponse(
            username = username,
            role = userRole,
            createdDate = createdDate,
            updatedDate = updatedDate,
            location = location
        )
    }
}