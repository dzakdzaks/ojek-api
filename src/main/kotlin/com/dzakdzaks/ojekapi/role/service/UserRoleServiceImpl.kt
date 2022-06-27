package com.dzakdzaks.ojekapi.role.service

import com.dzakdzaks.ojekapi.role.entity.UserRole
import com.dzakdzaks.ojekapi.role.repository.UserRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserRoleServiceImpl(
    @Autowired private val userRoleRepository: UserRoleRepository
): UserRoleService {


    override fun createUserRole(userRole: UserRole): Result<Boolean> {
        return userRoleRepository.createUserRole(userRole)
    }

    override fun getUserRoleById(id: String): Result<UserRole> {
        return userRoleRepository.getUserRoleById(id)
    }
}