package com.cmota.unsplash.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cmota.unsplash.shared.ServiceLocator
import com.cmota.unsplash.shared.data.model.Image
import com.cmota.unsplash.shared.domain.cb.UnsplashData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "UnsplashViewModel"

class UnsplashViewModel : ViewModel(), UnsplashData {

    private val _images = MutableLiveData<List<Image>>()
    val images: LiveData<List<Image>> = _images

    private val presenter by lazy {
        ServiceLocator.getUnsplashPresenter
    }

    fun fetchImages() {
        Log.d(TAG, "fetchImages")
        _images.value = emptyList()
        presenter.fetchImages(this)
    }

    fun searchForATopic(keyword: String) {
        Log.d(TAG, "searchForATopic")
        presenter.searchForImage(keyword, this)
    }

    // region UnsplashData

    override fun onNewDataAvailable(items: List<Image>, e: Exception?) {
        Log.d(TAG, "onNewDataAvailable | items=${items.size}")
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _images.value = items
            }
        }
    }

    // endregion FeedData
}
