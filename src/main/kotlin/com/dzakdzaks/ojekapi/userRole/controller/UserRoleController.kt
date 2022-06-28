package com.dzakdzaks.ojekapi.userRole.controller

import com.dzakdzaks.ojekapi.userRole.entity.UserRole
import com.dzakdzaks.ojekapi.userRole.service.UserRoleService
import com.dzakdzaks.ojekapi.util.entity.BaseResponse
import com.dzakdzaks.ojekapi.util.ext.toResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(UserRoleController.PATH_BASE)
class UserRoleController {

    @Autowired
    private lateinit var userRoleService: UserRoleService

    @PostMapping(PATH_CREATE_USER_ROLE)
    fun createUserRole(
        @RequestBody userRole: UserRole
    ): BaseResponse<Boolean> {
        return userRoleService.createUserRole(userRole).toResponse()
    }

    @GetMapping(PATH_GET_USER_ROLE_BY_ID)
    fun getUserRoleById(
        @PathVariable(name = "id") id: String
    ): BaseResponse<UserRole> {
        return userRoleService.getUserRoleById(id).toResponse()
    }

    companion object {
        const val PATH_BASE = "/api/v1/user-role"
        const val PATH_CREATE_USER_ROLE = "/create"
        const val PATH_GET_USER_ROLE_BY_ID = "/{id}"
    }

}