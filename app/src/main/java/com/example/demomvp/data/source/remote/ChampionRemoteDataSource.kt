package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.model.ChampionEntry
import com.example.demomvp.data.source.remote.fetchJson.GetJsonFromUrl
import com.example.demomvp.data.source.repository.ChampionDataSource
import com.example.demomvp.utils.Constant

class ChampionRemoteDataSource : ChampionDataSource.Remote {

    private var baseUrl = Constant.BASE_URL + Constant.VERSION_DATA + Constant.BASE_LANGUAGE + Constant.CHAMPION_JSON

    private object Holder {
        val INSTANCE = ChampionRemoteDataSource()
    }

    companion object {
        val instance: ChampionRemoteDataSource by lazy { Holder.INSTANCE }
    }

    override fun getChampions(listener: OnFetchDataJsonListener<MutableList<Champion>>) {
        @Suppress("DEPRECATION")
        GetJsonFromUrl(listener, ChampionEntry.CHAMPION).execute(baseUrl)
    }
}
