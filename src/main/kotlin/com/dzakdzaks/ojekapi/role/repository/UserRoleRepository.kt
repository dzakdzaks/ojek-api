package com.dzakdzaks.ojekapi.role.repository

import com.dzakdzaks.ojekapi.role.entity.UserRole

interface UserRoleRepository {
    fun createUserRole(userRole: UserRole): Result<Boolean>
    fun getUserRoleById(id: String): Result<UserRole>
}