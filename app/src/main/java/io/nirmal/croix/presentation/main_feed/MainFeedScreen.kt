package io.nirmal.croix.presentation.main_feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.nirmal.croix.presentation.components.Post
import io.nirmal.croix.presentation.components.StandardScaffold


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFeedScreen(
    navController: NavController
) {
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