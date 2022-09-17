package io.nirmal.croix.presentation.activity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.Activity
import io.nirmal.croix.domain.utils.ActivityAction
import io.nirmal.croix.presentation.ui.theme.SpaceSmall

@Composable
fun ActivityItem(
    activity: Activity,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        backgroundColor = androidx.compose.material3.MaterialTheme.colorScheme.surface,
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val fillerText = when(activity.actionType) {
                is ActivityAction.CommentedOnPost -> {
                    stringResource(id = R.string.commented_on)
                }
                is ActivityAction.LikedPost -> {
                    stringResource(id = R.string.liked)
                }
            }

            val actionText = when(activity.actionType) {
                is ActivityAction.CommentedOnPost -> {
                    stringResource(id = R.string.your_post)
                }
                is ActivityAction.LikedPost -> {
                    stringResource(id = R.string.your_post)
                }
            }

            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(fontWeight = FontWeight.Bold)
                    withStyle(boldStyle) {
                        append(activity.username)
                    }
                    append(" $fillerText ")
                    withStyle(boldStyle) {
                        append(actionText)
                    }
                },
                fontSize = 12.sp,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = activity.formattedTime,
                textAlign = TextAlign.Right,
                fontSize = 12.sp,
                color = androidx.compose.material3.MaterialTheme.colorScheme.onSurface

            )
        }

    }
}