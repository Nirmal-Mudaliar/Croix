package io.nirmal.croix.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.Activity
import io.nirmal.croix.domain.utils.ActivityAction
import io.nirmal.croix.domain.utils.DateFormatUtil
import io.nirmal.croix.presentation.activity.ActivityItem
import io.nirmal.croix.presentation.components.StandardScaffold
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.ui.theme.SpaceMedium
import io.nirmal.croix.presentation.ui.theme.SpaceSmall
import kotlin.random.Random

@Composable
fun ProfileScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(SpaceMedium)


        ) {
            items(20) {

            }
        }


    }
}