package io.nirmal.croix.feature_auth.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.states.PasswordTextFieldState
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.UiText
import io.nirmal.croix.feature_auth.domain.use_case.RegisterUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
): ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldStates())
    val emailState: State<StandardTextFieldStates> = _emailState

    private val _usernameState = mutableStateOf(StandardTextFieldStates())
    val usernameState: State<StandardTextFieldStates> = _usernameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: RegisterEvent) {
        when(event) {
            is RegisterEvent.EnteredUsername -> {
                _usernameState.value = usernameState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.EnteredEmail -> {
                _emailState.value = emailState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.EnteredPassword -> {
                _passwordState.value = passwordState.value.copy(
                    text = event.value
                )
            }
            is RegisterEvent.TogglePasswordVisibility -> {
                _passwordState.value = passwordState.value.copy(
                    isPasswordVisible = !passwordState.value.isPasswordVisible
                )
            }

            is RegisterEvent.Register -> {

                register()
            }
        }
    }

    private fun register() {
        viewModelScope.launch {
            _usernameState.value = usernameState.value.copy(error = null)
            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _registerState.value = registerState.value.copy(isLoading = true)

            val registerResult = registerUseCase(
                email = emailState.value.text.trim(),
                username = usernameState.value.text.trim(),
                password = passwordState.value.text.trim()
            )
            if (registerResult.emailError != null) {
                _emailState.value = _emailState.value.copy(error = registerResult.emailError)
            }
            if (registerResult.usernameError != null) {
                _usernameState.value = _usernameState.value.copy(error = registerResult.usernameError)
            }
            if (registerResult.passwordError != null) {
                _passwordState.value = _passwordState.value.copy(error = registerResult.passwordError)
            }
            when(registerResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(UiText.StringResource(R.string.success_registration))
                    )
                    _registerState.value = RegisterState(isLoading = false)
                    _usernameState.value = StandardTextFieldStates()
                    _emailState.value = StandardTextFieldStates()
                    _passwordState.value = PasswordTextFieldState()
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(registerResult.result.uiText ?: UiText.unknownError())
                    )
                    _registerState.value = RegisterState(isLoading = false)

                }
                null -> {
                    _registerState.value = RegisterState(isLoading = false)

                }
            }
        }
    }


    sealed class UiEvent {
        data class SnackbarEvent(val uiText: UiText): UiEvent()
    }

}