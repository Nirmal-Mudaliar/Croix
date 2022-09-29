package io.nirmal.croix.feature_auth.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import io.nirmal.croix.core.util.Constants
import io.nirmal.croix.feature_auth.presentation.util.AuthError


@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel
    : RegisterViewModel = hiltViewModel(),
) {

    val usernameState = registerViewModel.usernameState.value
    val emailState = registerViewModel.emailState.value
    val passwordState = registerViewModel.passwordState.value

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
                text = stringResource(R.string.register),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge,
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    registerViewModel.onEvent(RegisterEvent.EnteredEmail(it))
                },
                keyboardType = KeyboardType.Email,
                error = when(emailState.error) {
                   is AuthError.FieldEmpty -> {
                       stringResource(id = R.string.this_field_cant_be_empty)
                   }
                    is AuthError.InvalidEmail -> {
                        stringResource(id = R.string.not_a_valid_email)
                    }
                    else -> ""
               },
                hint = stringResource(R.string.email)

            )

            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = usernameState.text,
                onValueChange = {
                    registerViewModel.onEvent(RegisterEvent.EnteredUsername(it))
                },
                error = when(usernameState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }
                    else -> ""
                },
                hint = stringResource(R.string.username)

            )

            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    registerViewModel.onEvent(RegisterEvent.EnteredPassword(it))
                },
                hint = stringResource(R.string.password),
                error = when(passwordState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.this_field_cant_be_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    is AuthError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    else -> ""
                },
                keyboardType = KeyboardType.Password,
                showPasswordToggle = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    registerViewModel.onEvent(RegisterEvent.TogglePasswordVissibility)
                }

            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = { registerViewModel.onEvent(RegisterEvent.Register) },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colorScheme.onPrimary

                )
            }
        }
        Text(text = buildAnnotatedString {
            append(stringResource(R.string.already_have_an_account))
            append(" ")
            val signUpText = stringResource(id = R.string.sign_in)
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
                    navController.popBackStack()
                }

        )
    }

}