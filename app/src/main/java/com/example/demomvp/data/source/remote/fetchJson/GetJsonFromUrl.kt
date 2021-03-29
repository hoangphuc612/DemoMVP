@file:Suppress("DEPRECATION")

package com.example.demomvp.data.source.remote.fetchJson

import android.os.AsyncTask
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import org.json.JSONObject
import java.lang.Exception

class GetJsonFromUrl<T> constructor(
    private val listener: OnFetchDataJsonListener<T>,
    private val keyEntity: String
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String? {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(params[0]).toString()
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (result != null && !result.isBlank()) {
            val jsonObject = JSONObject(result)
            @Suppress("UNCHECKED_CAST")
            listener.onSuccess(ParseDataWithJson().parseJsonToData(jsonObject, keyEntity) as T)
        } else listener.onError(exception)
    }
}
