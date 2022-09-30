package io.nirmal.croix.feature_auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.states.PasswordTextFieldState
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.Screen
import io.nirmal.croix.core.util.UiText
import io.nirmal.croix.feature_auth.domain.use_case.LoginUseCase
import io.nirmal.croix.feature_auth.presentation.register.RegisterState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldStates())
    val emailState: State<StandardTextFieldStates> = _emailState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.EnteredEmail -> {
                _emailState.value = emailState.value.copy(text = event.value)
            }
            is LoginEvent.EnteredPassword -> {
                _passwordState.value = passwordState.value.copy(text = event.value)
            }
            is LoginEvent.TogglePasswordVisibility -> {
                _passwordState.value = passwordState.value.copy(isPasswordVisible = !passwordState.value.isPasswordVisible)
            }
            is LoginEvent.Login -> {
                login()
            }
        }
    }

    fun login() {
        viewModelScope.launch {

            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)

            _loginState.value = loginState.value.copy(isLoading = true)

            val loginResult = loginUseCase(email = emailState.value.text.trim(), password = passwordState.value.text.trim())

            _loginState.value = loginState.value.copy(isLoading = false)


            if (loginResult.emailError != null) {
                _emailState.value = emailState.value.copy(error = loginResult.emailError)
            }
            if (loginResult.passwordError != null) {
                _passwordState.value = passwordState.value.copy(error = loginResult.passwordError)
            }

            when(loginResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.NavigateEvent(Screen.MainFeedScreen.route)
                    )
                    _emailState.value = emailState.value.copy(error = null)
                    _passwordState.value = passwordState.value.copy(error = null)
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.SnackbarEvent(loginResult.result.uiText ?: UiText.unknownError())

                    )
                }

            }
        }
    }

    sealed class UiEvent {
        data class SnackbarEvent(val value: UiText): UiEvent()
        data class NavigateEvent(val route: String): UiEvent()
    }

}