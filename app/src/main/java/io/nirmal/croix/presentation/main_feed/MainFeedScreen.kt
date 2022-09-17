package io.nirmal.croix.presentation.main_feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.presentation.components.Post
import io.nirmal.croix.presentation.components.StandardScaffold
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.utils.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            },
            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,
            navActions = {
                IconButton(onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            }


        )
        Post(
            post = io.nirmal.croix.domain.models.Post(
                username = "Nirmal Mudaliar",
                imageUrl = "",
                profilePictureUrl = "",
                description = "kj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdsdfgdfsg dfgdfg sdfgdfg This is Nirma; dsfg dfg sdfg sdf dsfg fdg s dfg gfflj kdj k jdf kkljkdjkj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdflj kdj k jdf kkljkdj hi",
                likeCount = 10,
                commentCount = 6
            ),
            onPostClick = {
                navController.navigate(Screen.PostDetailScreen.route)
            }
        )
        Post(
            post = io.nirmal.croix.domain.models.Post(
                username = "Nirmal Mudaliar",
                imageUrl = "",
                profilePictureUrl = "",
                description = "kj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdsdfgdfsg dfgdfg sdfgdfg dsfg dfg sdfg sdf dsfg fdg s dfg gfflj kdj k jdf kkljkdjkj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdflj kdj k jdf kkljkdj",
                likeCount = 10,
                commentCount = 6
            )
        )

    }

}