package com.dzakdzaks.ojekapi.user.repository

import com.dzakdzaks.ojekapi.database.DatabaseComponent
import com.dzakdzaks.ojekapi.user.entity.User
import com.dzakdzaks.ojekapi.util.exception.ResponseException
import com.dzakdzaks.ojekapi.util.ext.toResult
import com.mongodb.client.MongoCollection
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    @Autowired private val databaseComponent: DatabaseComponent
): UserRepository {

    private fun userCollection(): MongoCollection<User> = databaseComponent.database.getCollection()

    override fun createUser(user: User): Result<Boolean> {
        val existingUser = getUserByUsername(user.username)
        return if (existingUser.isSuccess) {
            throw ResponseException("User already exist")
        } else {
            userCollection().insertOne(user).wasAcknowledged().toResult()
        }
    }

    override fun getUserById(id: String): Result<User> {
        return userCollection().findOneById(id).toResult("Username not found")
    }

    override fun getUserByUsername(username: String): Result<User> {
        return userCollection().findOne(User::username eq username).toResult("Username not found")
    }
}