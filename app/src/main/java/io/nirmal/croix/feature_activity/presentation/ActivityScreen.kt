package io.nirmal.croix.feature_activity.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.models.Activity
import io.nirmal.croix.feature_activity.data.ActivityAction
import io.nirmal.croix.core.util.DateFormatUtil
import io.nirmal.croix.presentation.activity.ActivityItem
import io.nirmal.croix.core.presentation.components.StandardToolbar
import io.nirmal.croix.core.presentation.theme.SpaceMedium
import io.nirmal.croix.core.presentation.theme.SpaceSmall
import kotlin.random.Random

@Composable
fun ActivityScreen(
    navController: NavController,
    viewModel: ActivityViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_activity),
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
                ActivityItem(
                    activity = Activity(
                        username = "Beiber",
                        actionType = if (Random.nextInt(2) == 0) {
                            ActivityAction.LikedPost
                        } else {
                        ActivityAction.CommentedOnPost
                        },
                        formattedTime = DateFormatUtil.timestampToFormattedString(System.currentTimeMillis(), "MMM dd, HH:mm")
                    ),
                    modifier = Modifier
                        .padding(SpaceSmall)
                )
                if (it < 19) {
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
            }
        }


    }
}