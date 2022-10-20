package com.cmota.unsplash.shared.data

import android.util.Log
import io.ktor.client.plugins.logging.Logger

private const val TAG = "HttpClientLogger"

public object HttpClientLogger : Logger {

    override fun log(message: String) {
        Log.d(TAG, message)
    }
}