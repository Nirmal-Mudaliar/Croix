package io.nirmal.croix.feature_auth.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.core.presentation.components.StandardTextField
import io.nirmal.croix.core.presentation.theme.SpaceLarge
import io.nirmal.croix.core.presentation.theme.SpaceMedium
import io.nirmal.croix.core.presentation.util.asString
import io.nirmal.croix.core.util.Screen
import io.nirmal.croix.feature_auth.presentation.util.AuthError
import kotlinx.coroutines.flow.collectLatest


@Composable
fun LoginScreen(
    navController: NavController,
    scaffoldState: androidx.compose.material.ScaffoldState,
    loginViewModel: LoginViewModel = hiltViewModel(),
) {
    val emailState = loginViewModel.emailState.value
    val passwordState = loginViewModel.passwordState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        loginViewModel.eventFlow.collectLatest { event ->
            when(event) {
                is LoginViewModel.UiEvent.SnackbarEvent -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.value.asString(context)
                    )
                }
                is LoginViewModel.UiEvent.NavigateEvent -> {
                    navController.navigate(event.route)
                }
            }

        }
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp,
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.login),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge,
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    loginViewModel.onEvent(LoginEvent.EnteredEmail(it))
                },
                keyboardType = KeyboardType.Email,
                error = when(emailState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = R.string.this_field_cant_be_empty)
                    else -> ""
               },
                hint = stringResource(R.string.email)

            )

            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    loginViewModel.onEvent(LoginEvent.EnteredPassword(it))
                },
                hint = stringResource(R.string.password),
                error = when(passwordState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = R.string.this_field_cant_be_empty)
                    else -> ""
                },
                keyboardType = KeyboardType.Password,
                showPasswordToggle = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    loginViewModel.onEvent(LoginEvent.TogglePasswordVisibility)
                }

            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    loginViewModel.onEvent(LoginEvent.Login)
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.White

                )
            }
        }
        Text(text = buildAnnotatedString {
            append(stringResource(R.string.dont_have_an_account_yet))
            append(" ")
            val signUpText = stringResource(id = R.string.sign_up)
            withStyle(style = SpanStyle(
                color = MaterialTheme.colorScheme.primary
            )) {
                append(signUpText)

            }
        },
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }
        )
    }

}