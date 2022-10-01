package io.nirmal.croix.feature_post.data.repository

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import androidx.core.net.toFile
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import io.nirmal.croix.R
import io.nirmal.croix.core.domain.models.Post
import io.nirmal.croix.core.domain.util.getFileName
import io.nirmal.croix.core.util.Constants
import io.nirmal.croix.core.util.Resource
import io.nirmal.croix.core.util.SimpleResource
import io.nirmal.croix.core.util.UiText
import io.nirmal.croix.feature_post.data.data_source.remote.PostApi
import io.nirmal.croix.feature_post.data.data_source.remote.request.CreatePostRequest
import io.nirmal.croix.feature_post.data.paging.PostSource
import io.nirmal.croix.feature_post.domain.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class PostRepositoryImpl(
    private val api: PostApi,
    private val gson: Gson,
    private val appContext: Context
): PostRepository {

    override val posts: Flow<PagingData<Post>>
        get() = Pager(PagingConfig(pageSize = Constants.PAGE_SIZE_POST)) {
            PostSource(api)
        }.flow

    override suspend fun createPost(description: String, imageUri: Uri): SimpleResource {
        val request = CreatePostRequest(description = description)
        val file = withContext(Dispatchers.IO) {
            appContext.contentResolver.openFileDescriptor(imageUri, "r")?.let { fd ->
                val inputStream = FileInputStream(fd.fileDescriptor)
                val file = File(
                    appContext.cacheDir,
                    appContext.contentResolver.getFileName(imageUri)
                )
                val outputStream = FileOutputStream(file)
                inputStream.copyTo(outputStream)
                file
            }
        } ?: return Resource.Error(
                uiText = UiText.StringResource(R.string.error_file_not_found),
                data = null
            )

        return try {
            val response = api.createPost(
                postData = MultipartBody.Part
                    .createFormData("post_data", gson.toJson(request)),
                postImaage = MultipartBody.Part
                    .createFormData(name = "post_image", filename = file.name, body = file.asRequestBody())

            )
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(uiText = UiText.DynamicString(msg))
                } ?: Resource.Error(uiText = UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(uiText = UiText.StringResource(R.string.error_couldnt_reach_server))
        } catch (e: HttpException) {
            Resource.Error(uiText = UiText.StringResource(R.string.error_something_went_wrong))
        }
    }
}