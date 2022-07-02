package com.dzakdzaks.ojekapi.user.service

import com.dzakdzaks.ojekapi.authentication.BCrypt
import com.dzakdzaks.ojekapi.authentication.JwtConfig
import com.dzakdzaks.ojekapi.userRole.repository.UserRoleRepository
import com.dzakdzaks.ojekapi.user.entity.*
import com.dzakdzaks.ojekapi.user.repository.UserRepository
import com.dzakdzaks.ojekapi.util.exception.ResponseException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val userRoleRepository: UserRoleRepository,
    @Autowired private val bCrypt: BCrypt
) : UserService {
    override fun register(userRegister: UserRegister, role: String): Result<Boolean> {
        userRegister.password = bCrypt.bCrypt().encode(userRegister.password)
        return userRepository.createUser(userRegister.toUser(role))
    }

    override fun login(userLogin: UserLogin): Result<LoginResponse> {
        val resultUser = userRepository.getUserByUsername(userLogin.username)
        return resultUser.map {
            val passwordInDb = it.password
            val passwordRequest = userLogin.password
            if (bCrypt.bCrypt().matches(passwordRequest, passwordInDb)) {
                val token = JwtConfig.generateToken(it)
                LoginResponse(token, it.toResponseUser(userRoleRepository.getUserRoleById(it.role).getOrNull()))
            } else {
                throw ResponseException("Password invalid")
            }
        }
    }

    override fun getUserById(id: String): Result<UserResponse> {
        return userRepository.getUserById(id).map {
            it.toResponseUser(
                userRoleRepository.getUserRoleById(it.role).getOrNull()
            )
        }
    }

    override fun getUserByUsername(username: String): Result<UserResponse> {
        return userRepository.getUserByUsername(username).map {
            it.toResponseUser(
                userRoleRepository.getUserRoleById(it.role).getOrNull()
            )
        }
    }

}