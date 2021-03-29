@file:Suppress("DEPRECATION")

package com.example.demomvp.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

class LoadImageBitmap(
    private val imageChampion: ImageView
) : AsyncTask<String?, Void?, Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = URL(params[0].toString())
        val connection = url.openConnection() as HttpURLConnection
        connection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            doOutput = true
            connect()
        }
        return BitmapFactory.decodeStream(url.openStream())
    }

    override fun onPostExecute(result: Bitmap?) {
        imageChampion.setImageBitmap(result)
    }

    companion object {
        const val TIME_OUT = 20000
        const val METHOD_GET = "GET"
    }
}
