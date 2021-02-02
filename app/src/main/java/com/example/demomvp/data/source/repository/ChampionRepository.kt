package com.example.demomvp.data.source.repository

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.local.ChampionLocalDataSource
import com.example.demomvp.data.source.remote.ChampionRemoteDataSource
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

class ChampionRepository private constructor(private val remote: ChampionDataSource.Remote,
                                             private val local: ChampionDataSource.Local) {

    private object Holder {
        val INSTANCE = ChampionRepository(
            remote = ChampionRemoteDataSource.instance,
            local = ChampionLocalDataSource.instance
        )
    }

    companion object {
        val instance: ChampionRepository by lazy { Holder.INSTANCE }
    }

    fun getChampion(listener: OnFetchDataJsonListener<MutableList<Champion>>) {
        remote.getChampions(listener)
    }
}
