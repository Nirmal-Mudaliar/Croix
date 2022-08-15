package io.nirmal.croix.presentation.main_feed

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import io.nirmal.croix.presentation.components.Post


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