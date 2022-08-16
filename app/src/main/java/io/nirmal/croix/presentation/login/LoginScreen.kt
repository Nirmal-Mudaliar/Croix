package io.nirmal.croix.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
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
                text = stringResource(R.string.login),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.headlineLarge,
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = loginViewModel.usernameText.value,
                onValueChange = {
                    loginViewModel.setUsernameText(it)
                },
                error = loginViewModel.usernameError.value,
                hint = stringResource(R.string.username_email)

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
                onClick = {
                    navController.navigate(Screen.MainFeedScreen.route)
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