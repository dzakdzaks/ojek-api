package com.dzakdzaks.ojekapi.role.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.newId

data class UserRole(
    @BsonId
    val id: String = newId<UserRole>().toString(),
    var name: String
) {
    fun toResponse(): UserRole {
        return UserRole(
            id = id,
            name = name
        )
    }
}