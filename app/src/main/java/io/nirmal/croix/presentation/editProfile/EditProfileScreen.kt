package io.nirmal.croix.presentation.editProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import io.nirmal.croix.R
import io.nirmal.croix.presentation.components.StandardTextField
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.editProfile.components.Chip
import io.nirmal.croix.presentation.ui.theme.ProfilePictureSizeLarge
import io.nirmal.croix.presentation.ui.theme.SpaceLarge
import io.nirmal.croix.presentation.ui.theme.SpaceMedium
import io.nirmal.croix.presentation.utils.Screen
import io.nirmal.croix.presentation.utils.states.StandardTextFieldStates
import kotlin.random.Random

@Composable
fun EditProfileScreen(
    navController: NavController,
    viewModel: EditProfileViewModel = hiltViewModel(),
    profilePictureSize : Dp = ProfilePictureSizeLarge,
) {
//    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.edit_your_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            navActions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.save_changes),
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            BannerEditSection(
                bannerImage = painterResource(id = R.drawable.img2),
                profileImage = painterResource(id = R.drawable.profile),
                profilePictureSize = profilePictureSize
            )
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceLarge)
            ) {
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.usernameStates.value.text,
                    hint = stringResource(id = R.string.username),
                    error = viewModel.usernameStates.value.error,
                    onValueChange = {
                        viewModel.setUsernameState(
                            StandardTextFieldStates(text = it)
                        )
                    },
                    leadingIcon = Icons.Default.Person


                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.githubTextFieldState.value.text,
                    hint = stringResource(id = R.string.github_profile_url),
                    error = viewModel.githubTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setGithubTextFieldState(
                            StandardTextFieldStates(text = it)
                        )
                    },
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_github)

                )
                Spacer(modifier = Modifier.height(SpaceMedium))

                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.instagramTextFieldState.value.text,
                    hint = stringResource(id = R.string.instagram_profile_url),
                    error = viewModel.instagramTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setInstagramTextFieldState(
                            StandardTextFieldStates(text = it)
                        )
                    },
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_instagram)

                )
                Spacer(modifier = Modifier.height(SpaceMedium))

                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.linkedinTextFieldState.value.text,
                    hint = stringResource(id = R.string.linkedin_profile_url),
                    error = viewModel.linkedinTextFieldState.value.error,
                    onValueChange = {
                        viewModel.setLinkedinTextFieldState(
                            StandardTextFieldStates(text = it)
                        )
                    },
                    leadingIcon = ImageVector.vectorResource(id = R.drawable.ic_linkedin)

                )

                Spacer(modifier = Modifier.height(SpaceMedium))

                StandardTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = viewModel.bioState.value.text,
                    hint = stringResource(id = R.string.bio),
                    error = viewModel.bioState.value.error,
                    onValueChange = {
                        viewModel.setBioState(
                            StandardTextFieldStates(text = it)
                        )
                    },
                    leadingIcon = Icons.Default.Description,
                    singleLine = false,
                    maxLines = 3

                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = stringResource(id = R.string.select_top_3_skills),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    mainAxisAlignment = MainAxisAlignment.Center,
                    mainAxisSpacing = SpaceMedium,
                    crossAxisSpacing = SpaceMedium
                ) {
                    listOf(
                        "kotlin",
                        "javascript",
                        "Assembly",
                        "C++",
                        "C",
                        "TypeScript",
                        "Python",
                        "Ruby",
                        "Go"
                    ).forEach {
                        Chip(
                            text = it,
                            selected = Random.nextInt(2) == 0
                        ) {

                        }
                    }
                }
            }


        }
    }

}

@Composable
fun BannerEditSection(
    bannerImage: Painter,
    profileImage: Painter,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    onBannerClick: () -> Unit = {},
    onProfileImageClick: () -> Unit = {},
) {
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 1.75f).dp

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(bannerHeight + profilePictureSize / 2f)
    ) {
        Image(
            painter = bannerImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
//                    .aspectRatio(1.75f)
                .height(bannerHeight)
        )

        Image(
            painter = profileImage,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(profilePictureSize)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = CircleShape
                )
        )
    }
}








