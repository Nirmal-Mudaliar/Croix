package io.nirmal.croix.feature_post.presentation.create_post

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.core.presentation.components.StandardTextField
import io.nirmal.croix.core.presentation.components.StandardToolbar
import io.nirmal.croix.core.presentation.theme.SpaceLarge
import io.nirmal.croix.core.presentation.theme.SpaceMedium
import io.nirmal.croix.core.presentation.theme.SpaceSmall
import io.nirmal.croix.core.domain.states.StandardTextFieldStates
import io.nirmal.croix.feature_post.presentation.util.PostDescriptionError

@Composable
fun CreatePostScreen(
    navController: NavController,
    viewModel: CreatePostViewModel = hiltViewModel(),
) {

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {
        viewModel.onEvent(CreatePostEvent.PickImage(it))
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        StandardToolbar(
            navController = navController,
            showBackArrow = true,
            title = {
                Text(
                    text = stringResource(id = R.string.create_a_new_post),
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
            Box(
                modifier = Modifier
                    .aspectRatio(16f / 9f)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = androidx.compose.material.MaterialTheme.shapes.medium
                    )
                    .clickable {
                        galleryLauncher.launch("image/*")
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.choose_image),
                    tint = MaterialTheme.colorScheme.onBackground,

                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                text = viewModel.descriptionState.value.text,
                hint = stringResource(id = R.string.description),
                error = when(viewModel.descriptionState.value.error) {
                    is PostDescriptionError.FieldEmpty -> stringResource(id = R.string.this_field_cant_be_empty)
                    else -> ""
                 },
                onValueChange = {
                    viewModel.onEvent(CreatePostEvent.EnterDescription(it))
                },
                leadingIcon = Icons.Default.Description,
                singleLine = false,
                maxLines = 7,
                maxlenght = 50

            )
            Spacer(modifier = Modifier.height(SpaceLarge))
            androidx.compose.material3.Button(
                onClick = { viewModel.onEvent(CreatePostEvent.PostImage) },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.post),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Spacer(modifier = Modifier.width(SpaceSmall))
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = null
                )
            }
        }

    }
}