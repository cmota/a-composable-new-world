package com.cmota.unsplash.shared.domain

import android.util.Log
import com.cmota.unsplash.shared.data.UnsplashAPI
import com.cmota.unsplash.shared.data.model.Image
import kotlinx.coroutines.coroutineScope

private const val TAG = "GetUnsplashData"

public class GetUnsplashData {

    public suspend fun invoke(
        onSuccess: (List<Image>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        try {

            val result = UnsplashAPI.fetchImages()

            Log.d(TAG, "invoke | result=$result")

            coroutineScope {
                onSuccess(result)
            }
        } catch (e: Exception) {
            Log.w(TAG, "invoke | Exception=$e")

            coroutineScope {
                onFailure(e)
            }
        }
    }

    public suspend fun invokeSearch(
        keyword: String,
        onSuccess: (List<Image>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        try {
            val result = UnsplashAPI.searchImages(keyword)

            Log.d(TAG, "invokeSearch | result=$result")

            coroutineScope {
                onSuccess(result.results)
            }
        } catch (e: Exception) {
            coroutineScope {
                onFailure(e)
            }
        }
    }
}