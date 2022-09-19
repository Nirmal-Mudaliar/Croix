package io.nirmal.croix.presentation.post_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.nirmal.croix.R
import io.nirmal.croix.domain.models.Comment
import io.nirmal.croix.domain.models.Post
import io.nirmal.croix.presentation.components.ActionRow
import io.nirmal.croix.presentation.components.StandardToolbar
import io.nirmal.croix.presentation.ui.theme.*

@Composable
fun PostDetailScreen(
    navController: NavController,
    post: Post
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize()) {
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
            showBackArrow = true,
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface)


            ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
//                        .background(Color(0xFFF3F3F3))

                ) {

                    Spacer(modifier = Modifier.height(SpaceLarge))

                    Box(
                        modifier = Modifier
                            .fillMaxSize()



                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .offset(y = ProfilePictureSizeMedium / 2f)
                                .clip(RoundedCornerShape(8.dp))
                                .shadow(5.dp)
                                .background(MaterialTheme.colorScheme.surface)


                        ) {
                            Image(
                                painterResource(id = R.drawable.kermit2),
                                contentDescription = "Post image",
                                modifier = Modifier.fillMaxWidth()

                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(SpaceLarge)

                            ) {
                                ActionRow(
                                    username = "Nirmal Mudaliar",
                                    modifier = Modifier.fillMaxWidth(),
                                    onLikeClick = { isLiked ->

                                    },
                                    onCommentClick = {

                                    },
                                    onShareClick = {

                                    },
                                    onUsernameClick = { username ->

                                    }
                                )
                                Spacer(modifier = Modifier.height(SpaceSmall))
                                Text(
                                    text = post.description,
                                    style = MaterialTheme.typography.bodyMedium,

                                    )

                                Spacer(modifier = Modifier.height(SpaceMedium))

                                Text(
                                    text = stringResource(id = R.string.liked_by_x_people, post.likeCount),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    style = MaterialTheme.typography.headlineSmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }


                        }

                        Image(
                            painterResource(id = R.drawable.profile),
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .size(ProfilePictureSizeMedium)
                                .clip(CircleShape)
                                .align(Alignment.TopCenter)
                        )
                    }


                }
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
            items(20) {
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceSmall,
                            vertical = 0.dp
                        ),
                    comment = Comment(
                        username = "Leo $it",
                        comment = "OPtimezed! djfh hsjdfhkj h jhsdjhf k lkdgfjlks jdlkgf sfdgfsd jkj sdfklj jksdjfkl sjdkfklsd lksjdfksj  kdjfk jdkfjskdjk jlkdjflksjdflkjsd klsdjflk sjdklfjlkdjf lk  kdsj                     sdjflkjdsf         jdkf k         jfksdjflksjdkf jkdfiohjsagDGJH JSHDF H JDHF JK FKJHSHFJK HDGF AJKKJFD",

                        )
                )
            }
        }


    }



}

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment = Comment(),
    onLikeClick: (Boolean) -> Unit = {}
) {
    
    Card(
        modifier = modifier
            .padding(SpaceSmall),
        elevation = 5.dp,
        shape = androidx.compose.material.MaterialTheme.shapes.small,
        backgroundColor = Color(0xFFF6F6F6)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceMedium)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(ProfilePictureSizeExtraSmall)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(SpaceSmall))
                    Text(
                        text = comment.username,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                Text(
                    text = "2 days ago",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .weight(9f)
                )
                IconButton(onClick = {
                        onLikeClick(comment.isLiked)
                    },
                    modifier = Modifier
                        .weight(1f)

                    ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = if(comment.isLiked) {
                            stringResource(id = R.string.unlike)
                        } else {
                            stringResource(id = R.string.like)
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            
            Text(
                text = stringResource(id = R.string.liked_by_x_people, comment.likeCount),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium
            )
        }

    }
    
}