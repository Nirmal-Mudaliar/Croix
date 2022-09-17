package io.nirmal.croix.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.User
import io.nirmal.croix.presentation.ui.theme.SpaceLarge
import io.nirmal.croix.presentation.ui.theme.SpaceMedium

@Composable
fun ProfileStats(
    user: User,
    modifier: Modifier = Modifier,
    isFollowing: Boolean = true,
    isOwnProfile: Boolean = true,
    onFollowClick: () -> Unit = {},

) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileNumber(
            number = user.followerCount,
            text = stringResource(id = R.string.followers)
        )
        Spacer(modifier = Modifier.width(SpaceLarge))
        ProfileNumber(
            number = user.followingCount,
            text = stringResource(id = R.string.following)
        )
        Spacer(modifier = Modifier.width(SpaceLarge))

        ProfileNumber(
            number = user.postCount,
            text = stringResource(id = R.string.post_count)
        )

        if (!isOwnProfile) {
            Spacer(modifier = Modifier.width(SpaceLarge))

            Button(
                onClick = onFollowClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isFollowing) Color.Red
                    else MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = if (isFollowing) {
                        stringResource(id = R.string.unfollow)
                    } else {
                        stringResource(id = R.string.follow)
                    },
                    color = Color.White
                )
            }
        }

    }
}