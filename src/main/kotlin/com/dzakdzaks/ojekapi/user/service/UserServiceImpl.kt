package com.dzakdzaks.ojekapi.user.service

import com.dzakdzaks.ojekapi.authentication.JwtConfig
import com.dzakdzaks.ojekapi.role.repository.UserRoleRepository
import com.dzakdzaks.ojekapi.role.service.UserRoleService
import com.dzakdzaks.ojekapi.user.entity.*
import com.dzakdzaks.ojekapi.user.repository.UserRepository
import com.dzakdzaks.ojekapi.util.exception.ResponseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val userRoleRepository: UserRoleRepository,
) : UserService {
    override fun register(userRegister: UserRegister, role: String): Result<Boolean> {
        return userRepository.createUser(userRegister.toUser(role))
    }

    override fun login(userLogin: UserLogin): Result<LoginResponse> {
        val resultUser = userRepository.getUserByUsername(userLogin.username)
        return resultUser.map {
            val token = JwtConfig.generateToken(it)
            val passwordInDb = it.password
            val passwordRequest = userLogin.password
            if (passwordInDb == passwordRequest) {
                LoginResponse(token, it.toResponseUser(userRoleRepository.getUserRoleById(it.role).getOrThrow()))
            } else {
                throw ResponseException("Password invalid")
            }
        }
    }

    override fun getUserById(id: String): Result<UserResponse> {
        return userRepository.getUserById(id).map {
            it.toResponseUser(
                userRoleRepository.getUserRoleById(it.role).getOrThrow()
            )
        }
    }

    override fun getUserByUsername(username: String): Result<UserResponse> {
        return userRepository.getUserByUsername(username).map {
            it.toResponseUser(
                userRoleRepository.getUserRoleById(it.role).getOrThrow()
            )
        }
    }

}