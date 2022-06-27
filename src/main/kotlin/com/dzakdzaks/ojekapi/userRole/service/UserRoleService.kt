package com.dzakdzaks.ojekapi.userRole.service

import com.dzakdzaks.ojekapi.userRole.entity.UserRole

interface UserRoleService {
    fun createUserRole(userRole: UserRole): Result<Boolean>
    fun getUserRoleById(id: String): Result<UserRole>
}