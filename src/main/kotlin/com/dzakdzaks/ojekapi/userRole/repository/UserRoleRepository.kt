package com.dzakdzaks.ojekapi.userRole.repository

import com.dzakdzaks.ojekapi.userRole.entity.UserRole

interface UserRoleRepository {
    fun createUserRole(userRole: UserRole): Result<Boolean>
    fun getUserRoleById(id: String): Result<UserRole>
}