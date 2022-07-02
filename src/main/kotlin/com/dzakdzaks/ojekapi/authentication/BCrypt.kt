package com.dzakdzaks.ojekapi.authentication

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class BCrypt {
    @Bean
    fun bCrypt() = BCryptPasswordEncoder()
}