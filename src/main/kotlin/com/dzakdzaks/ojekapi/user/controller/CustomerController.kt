package com.dzakdzaks.ojekapi.user.controller

import com.dzakdzaks.ojekapi.user.entity.*
import com.dzakdzaks.ojekapi.user.service.UserService
import com.dzakdzaks.ojekapi.util.entity.BaseResponse
import com.dzakdzaks.ojekapi.util.exception.ResponseException
import com.dzakdzaks.ojekapi.util.ext.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(CustomerController.PATH_BASE)
class CustomerController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): BaseResponse<UserResponse> {
        val id = SecurityContextHolder.getContext().authentication.principal as? String
        return userService.getUserById(id.orEmpty()).toResponse()
    }

    @PostMapping(PATH_REGISTER)
    fun register(
        @RequestBody userRegister: UserRegister
    ): BaseResponse<Boolean> {
        if (userRegister.username.isEmpty() || userRegister.password.isEmpty()) throw ResponseException("Username and Password cant empty")
        return userService.register(userRegister, "62b969541cedfa6d5aca29fe").toResponse()
    }

    @PostMapping(PATH_LOGIN)
    fun login(
        @RequestBody userLogin: UserLogin
    ): BaseResponse<LoginResponse> {
        if (userLogin.username.isEmpty() || userLogin.password.isEmpty()) throw ResponseException("Username and Password cant empty")
        return userService.login(userLogin).toResponse()
    }

    companion object {
        const val PATH_BASE = "/api/v1/customer"
        const val PATH_REGISTER = "/register"
        const val PATH_LOGIN = "/login"
    }
}