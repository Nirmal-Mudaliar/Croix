package io.nirmal.croix.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.nirmal.croix.R

@Composable
fun StandardToolbar(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBackArrow: Boolean = false,
    navActions: @Composable RowScope.()-> Unit = {},
    title: @Composable () -> Unit,
    
) {
    
    TopAppBar(
        title = title,
        navigationIcon = if (showBackArrow) {
            {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = stringResource(id = R.string.back),
                        tint = MaterialTheme.colorScheme.onBackground
                    )

                }
            }
        } else null,
        actions = navActions,
        backgroundColor = MaterialTheme.colorScheme.surface,
        elevation = 5.dp
    )
    
}