package com.dzakdzaks.ojekapi.util.exception

import com.dzakdzaks.ojekapi.util.entity.BaseResponse
import com.dzakdzaks.ojekapi.util.entity.Empty
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ResponseExceptionHandler {

    @ExceptionHandler(value = [ResponseException::class])
    fun handleException(exception: ResponseException): ResponseEntity<BaseResponse<Empty>> {
        return ResponseEntity(
            BaseResponse.failure(exception.message ?: "There is something error"),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}