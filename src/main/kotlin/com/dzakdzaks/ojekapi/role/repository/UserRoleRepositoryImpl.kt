package com.dzakdzaks.ojekapi.role.repository

import com.dzakdzaks.ojekapi.database.DatabaseComponent
import com.dzakdzaks.ojekapi.role.entity.UserRole
import com.dzakdzaks.ojekapi.util.exception.ResponseException
import com.dzakdzaks.ojekapi.util.ext.toResult
import com.mongodb.client.MongoCollection
import org.litote.kmongo.findOneById
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRoleRepositoryImpl(
    @Autowired private val databaseComponent: DatabaseComponent
): UserRoleRepository {

    private fun userRoleCollection(): MongoCollection<UserRole> = databaseComponent.database.getCollection()

    override fun createUserRole(userRole: UserRole): Result<Boolean> {
        val existingUserRole = getUserRoleById(userRole.id)
        return if (existingUserRole.isSuccess) {
            throw ResponseException("User role already exist")
        } else {
            userRoleCollection().insertOne(userRole).wasAcknowledged().toResult()
        }
    }

    override fun getUserRoleById(id: String): Result<UserRole> {
        return userRoleCollection().findOneById(id).toResult()
    }
}