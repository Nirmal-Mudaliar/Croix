package io.nirmal.croix.presentation.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.nirmal.croix.domain.models.Post
import io.nirmal.croix.presentation.activity.ActivityScreen
import io.nirmal.croix.presentation.chat.ChatScreen
import io.nirmal.croix.presentation.create_post.CreatePostScreen
import io.nirmal.croix.presentation.editProfile.EditProfileScreen
import io.nirmal.croix.presentation.main_feed.MainFeedScreen
import io.nirmal.croix.presentation.splash.SplashScreen
import io.nirmal.croix.presentation.login.LoginScreen
import io.nirmal.croix.presentation.post_detail.PostDetailScreen
import io.nirmal.croix.presentation.profile.ProfileScreen
import io.nirmal.croix.presentation.register.RegisterScreen
import io.nirmal.croix.presentation.search.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    username = "Nirmal Mudaliar",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "kj kjdkf jkj kjdflj kdj k jdf kkljkdhjhjdf jhkjh dhjkdhfjkshiodjlkfgj j lkj lkjkf j kj kjkl    jjlkjlksjdflkj kjf lkjfk              jkfjfksj             jdksjfkljllkjdlfj kj kjdkf jkj kjdsdfgdfsg dfgdfg sdfgdfg dsfg dfg sdfg sdf dsfg fdg s dfg gfflj kdj k jdf kkljkdjkj kjdkf jkj kjdflj kdj k jdf kkljkdj kj kjdkf jkj kjdflj kdj k jdf kkljkdj",
                    likeCount = 10,
                    commentCount = 6
                )
            )
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
    }
}
