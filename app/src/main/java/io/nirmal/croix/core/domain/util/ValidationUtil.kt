package io.nirmal.croix.core.domain.util

import android.util.Patterns
import io.nirmal.croix.core.util.Constants
import io.nirmal.croix.feature_auth.presentation.util.AuthError

object ValidationUtil {
    fun validateEmail(email: String): AuthError? {
        val trimmedEmail = email.trim()
        if (trimmedEmail.isBlank()) {
            return AuthError.FieldEmpty
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
           return AuthError.InvalidEmail
        }
        return null
    }

    fun validateUsername(username: String): AuthError? {
        val trimmedUsername = username.trim()
        if(trimmedUsername.isBlank()) {
            return AuthError.FieldEmpty
        }
        if (trimmedUsername.length < Constants.MIN_USERNAME_LENGTH) {
            return AuthError.InputTooShort
        }
        return null
    }

    fun validatePassword(password: String): AuthError? {
        val trimmedPassword = password.trim()
        if (trimmedPassword.isBlank()) {
            return AuthError.FieldEmpty
        }
        if (trimmedPassword.length < Constants.MIN_PASSWORD_LENGTH) {
            return AuthError.InputTooShort
        }
        val capitalLettersInPassword = trimmedPassword.any { it.isUpperCase() }
        val numberInPassword = trimmedPassword.any { it.isDigit() }

        if (!capitalLettersInPassword || !numberInPassword) {
            return AuthError.InvalidPassword
        }
        return null
    }
}