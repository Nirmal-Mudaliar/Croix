package io.nirmal.croix.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import io.nirmal.croix.R

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChange: (String)->Unit
) {

    var isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        placeholder = {
            Text(text = hint, style = MaterialTheme.typography.bodyLarge)
        },
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        visualTransformation = if (!isPasswordVisible && isPasswordToggleDisplayed) {
            PasswordVisualTransformation()
          } else {
                 VisualTransformation.None
         },
        trailingIcon = {
            if (isPasswordToggleDisplayed)
               IconButton(onClick = {
                   isPasswordVisible = !isPasswordVisible
               }) {
                   Icon(
                       imageVector = if (isPasswordVisible) {
                           Icons.Filled.VisibilityOff
                       } else {
                            Icons.Filled.Visibility
                              },
                       contentDescription = if (isPasswordVisible) {
                           stringResource(R.string.password_visible_content_description)
                       } else {
                           stringResource(R.string.password_hidden_content_description)
                       }
                   )
               }
        },
        modifier = Modifier.fillMaxWidth()
    )
}