package io.nirmal.croix.presentation.utils

sealed class Screens(val route: String){
    object SplashScreen: Screens("splash_screen")
    object LoginScreen: Screens("login_screen")
    object RegisterScreen: Screens("register_screen")
    object MainFeedScreen: Screens("main_feed_screen")
    object PostDetailScreen: Screens("post_detail_screen")
    object ChatScreen: Screens("chat_screen")
    object MessagesScreen: Screens("messages_screen")
    object ProfileScreen: Screens("profile_screen")
    object EditProfileScreen: Screens("edit_profile_screen")
    object PersonListScreen: Screens("person_list_screen")
    object CreatePostScreen: Screens("create_post_screen")
    object ActivityScreen: Screens("activity_screen")
    object SearchScreen: Screens("search_screen")

}
