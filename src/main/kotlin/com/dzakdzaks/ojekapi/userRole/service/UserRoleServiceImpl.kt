package com.dzakdzaks.ojekapi.userRole.service

import com.dzakdzaks.ojekapi.userRole.entity.UserRole
import com.dzakdzaks.ojekapi.userRole.repository.UserRoleRepository
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