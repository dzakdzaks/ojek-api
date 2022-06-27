package com.dzakdzaks.ojekapi.role.service

import com.dzakdzaks.ojekapi.role.entity.UserRole

interface UserRoleService {
    fun createUserRole(userRole: UserRole): Result<Boolean>
    fun getUserRoleById(id: String): Result<UserRole>
}