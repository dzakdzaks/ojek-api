package com.dzakdzaks.ojekapi.user.entity

import com.dzakdzaks.ojekapi.userRole.entity.UserRole
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.newId
import java.util.*

data class UserResponse(
    @BsonId
    val id: String = newId<User>().toString(),
    var username: String,
    var role: UserRole?,
    var createdDate: Date = Date(),
    var updatedDate: Date = Date()
)