package com.cmota.unsplash.shared.presentation

import android.util.Log
import com.cmota.unsplash.shared.PresenterCoroutineScope
import com.cmota.unsplash.shared.domain.GetUnsplashData
import com.cmota.unsplash.shared.domain.cb.UnsplashData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "UnsplashPresenter"

class UnsplashPresenter(private val data: GetUnsplashData) {

    private val scope = PresenterCoroutineScope(Dispatchers.Default)
    private var listener: UnsplashData? = null

    public fun fetchImages(cb: UnsplashData) {
        Log.d(TAG, "fetchImages")
        listener = cb

        fetchImages()
    }

    public fun searchForImage(keyword: String, cb: UnsplashData) {
        Log.d(TAG, "searchForImage | keyword=$keyword")
        listener = cb

        searchForImage(keyword)
    }

    private fun fetchImages() {
        scope.launch {
            data.invoke(
                onSuccess = { listener?.onNewDataAvailable(it, null) },
                onFailure = { listener?.onNewDataAvailable(emptyList(), it) }
            )
        }
    }

    private fun searchForImage(keyword: String) {
        scope.launch {
            data.invokeSearch(
                keyword = keyword,
                onSuccess = { listener?.onNewDataAvailable(it, null) },
                onFailure = { listener?.onNewDataAvailable(emptyList(), it) }
            )
        }
    }
}