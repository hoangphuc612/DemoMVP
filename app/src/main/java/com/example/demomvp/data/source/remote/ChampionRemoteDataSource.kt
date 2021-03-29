package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.model.ChampionEntry
import com.example.demomvp.data.source.remote.fetchJson.GetJsonFromUrl
import com.example.demomvp.data.source.ChampionDataSource
import com.example.demomvp.data.source.local.ChampionLocalDataSource
import com.example.demomvp.data.source.repository.ChampionRepository
import com.example.demomvp.utils.Constant

class ChampionRemoteDataSource : ChampionDataSource.Remote {

    private var baseUrl =
        Constant.BASE_URL +
        Constant.VERSION_DATA +
        Constant.BASE_LANGUAGE +
        Constant.CHAMPION_JSON

    override fun getChampions(
            listener: OnFetchDataJsonListener<MutableList<Champion>>
    ) {
        @Suppress("DEPRECATION")
        GetJsonFromUrl(listener, ChampionEntry.CHAMPION).execute(baseUrl)
    }

    companion object {
        @Volatile
        private var mInstance: ChampionRemoteDataSource? = null

        fun getRemote(): ChampionRemoteDataSource =
            mInstance ?: synchronized(this) {
                val newInstance =
                    mInstance ?: ChampionRemoteDataSource().also { mInstance = it }
                newInstance
            }
    }
}
