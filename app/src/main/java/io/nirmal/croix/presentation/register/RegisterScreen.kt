package io.nirmal.croix.presentation.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.presentation.components.StandardTextField
import io.nirmal.croix.presentation.ui.theme.SpaceLarge
import io.nirmal.croix.presentation.ui.theme.SpaceMedium
import io.nirmal.croix.presentation.ui.theme.White
import io.nirmal.croix.presentation.utils.Screen
import kotlin.math.log


@Composable
fun RegisterScreen(
    navController: NavController,
    loginViewModel: RegisterViewModel = hiltViewModel(),
) {

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
                text = loginViewModel.emailText.value,
                onValueChange = {
                    loginViewModel.setEmailText(it)
                },
                keyboardType = KeyboardType.Email,
                error = loginViewModel.emailError.value,
                hint = stringResource(R.string.email)

            )

            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = loginViewModel.usernameText.value,
                onValueChange = {
                    loginViewModel.setUsernameText(it)
                },
                error = loginViewModel.usernameError.value,
                hint = stringResource(R.string.username)

            )

            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = loginViewModel.passwordText.value,
                onValueChange = {
                    loginViewModel.setPasswordText(it)
                },
                hint = stringResource(R.string.password),
                error = loginViewModel.passwordError.value,
                keyboardType = KeyboardType.Password,
                showPasswordToggle = loginViewModel.showPassword.value,
                onPasswordToggleClick = {
                    loginViewModel.setShowPassword(it)
                }

            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {  },
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