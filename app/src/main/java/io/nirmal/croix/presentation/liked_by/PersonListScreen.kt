package io.nirmal.croix.presentation.liked_by

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.User
import io.nirmal.croix.presentation.components.StandardTextField
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.components.UserProfileItem
import io.nirmal.croix.presentation.ui.theme.IconSizeMedium
import io.nirmal.croix.presentation.ui.theme.SpaceLarge
import io.nirmal.croix.presentation.ui.theme.SpaceMedium
import io.nirmal.croix.presentation.ui.theme.SpaceSmall
import io.nirmal.croix.presentation.utils.Screen
import io.nirmal.croix.presentation.utils.states.StandardTextFieldStates

@Composable
fun PersonListScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.liked_by),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(SpaceLarge)
        ) {
            items(10) {
                UserProfileItem(
                    user = User(
                        profilePictureUrl = "",
                        username = "Nirmal Mudaliar",
                        description = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed\n" +
                                "diam nonumy eirmod tempor invidunt ut labore et dolore \n" +
                                "magna aliquyam erat, sed diam voluptua",
                        followerCount = 234,
                        followingCount = 534,
                        postCount = 65
                    ),
                    actionIcon = {
                        Icon(
                            imageVector = Icons.Default.PersonAdd,
                            contentDescription = null,

                            modifier = Modifier
                                .size(IconSizeMedium)
                        )

                    }
                )
            }
        }


    }
}