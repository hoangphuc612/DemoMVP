@file:Suppress("DEPRECATION")

package com.example.demomvp.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.net.HttpURLConnection
import java.net.URL

class LoadImageBitmap(private val imgImage: ImageView) : AsyncTask<String?,Void?,Bitmap?>() {

    override fun doInBackground(vararg params: String?): Bitmap? {
        val url = URL(params[0].toString())
        val connection = url.openConnection() as HttpURLConnection
        connection.connectTimeout = TIME_OUT
        connection.readTimeout = TIME_OUT
        connection.requestMethod = METHOD_GET
        connection.doOutput = true
        connection.connect()
        return BitmapFactory.decodeStream(url.openStream())
    }

    override fun onPostExecute(result: Bitmap?) {
        imgImage.setImageBitmap(result)
    }

    companion object {
        const val TIME_OUT = 20000
        const val METHOD_GET = "GET"
    }
}
