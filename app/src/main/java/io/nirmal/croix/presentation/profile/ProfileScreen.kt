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
import io.nirmal.croix.domain.models.Post
import io.nirmal.croix.domain.models.User
import io.nirmal.croix.domain.utils.ActivityAction
import io.nirmal.croix.domain.utils.DateFormatUtil
import io.nirmal.croix.presentation.activity.ActivityItem
import io.nirmal.croix.presentation.components.Post
import io.nirmal.croix.presentation.components.StandardScaffold
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.profile.components.BannerSection
import io.nirmal.croix.presentation.profile.components.ProfileHeaderSection
import io.nirmal.croix.presentation.ui.theme.ProfilePictureSizeLarge
import io.nirmal.croix.presentation.ui.theme.SpaceMedium
import io.nirmal.croix.presentation.ui.theme.SpaceSmall
import io.nirmal.croix.presentation.utils.Screen
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
        ) {
            item {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(1.75f)
                )
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        "",
                        username = "Nirmal Mudaliar",
                        description = "Deep Interest in Android Development",
                        10,
                        20,
                        100
                    )
                )
            }
            items(20) {
                Spacer(modifier = Modifier
                    .height(SpaceMedium)
                    .offset(y = -ProfilePictureSizeLarge / 2f),
                )
                Post(
                    post = Post(
                        username = "Nirmal Mudaliar",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = "kj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdsdfgdfsg dfgdfg sdfgdfg This is Nirma; dsfg dfg sdfg sdf dsfg fdg s dfg gfflj kdj k jdf kkljkdjkj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdflj kdj k jdf kkljkdj hi",
                        likeCount = 10,
                        commentCount = 6
                    ),
                    showProfileImage = false,
                    onPostClick = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },
                    modifier = Modifier
                        .offset(y = -ProfilePictureSizeLarge / 2f),
                )
            }
        }


    }
}