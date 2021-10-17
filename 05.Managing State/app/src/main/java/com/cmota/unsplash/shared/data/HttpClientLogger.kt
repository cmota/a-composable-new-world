package com.cmota.unsplash.shared.data

import android.util.Log

private const val TAG = "HttpClientLogger"

public object HttpClientLogger : io.ktor.client.features.logging.Logger {

    override fun log(message: String) {
        Log.d(TAG, message)
    }
}