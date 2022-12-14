package io.nirmal.croix.feature_profile.presentation.search.presentation

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.models.User
import io.nirmal.croix.core.presentation.components.StandardTextField
import io.nirmal.croix.core.presentation.components.StandardToolbar
import io.nirmal.croix.core.presentation.components.UserProfileItem
import io.nirmal.croix.core.presentation.theme.IconSizeMedium
import io.nirmal.croix.core.presentation.theme.SpaceLarge
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import io.nirmal.croix.core.util.Screen
import io.nirmal.croix.feature_profile.presentation.search.presentation.SearchViewModel

@Composable
fun SearchScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: SearchViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.search_for_users ),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
        ) 
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = viewModel.searchState.value.text,
                hint = stringResource(id = R.string.search),
                error = "",
                onValueChange = {
                    viewModel.setSearchState(
                        StandardTextFieldStates(text = it)
                    )
                },
                leadingIcon = Icons.Default.Search
            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(10) {
                    UserProfileItem(
                        user = User(
                            userId = "63384c4638601217c1d6c4ba",
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

                        },
                        onItemClick = {
                            onNavigate(
                                Screen.ProfileScreen.route + "?userId=63384c4638601217c1d6c4ba"
                            )
                        }
                    )
                }
            }
        }
    }
}