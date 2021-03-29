package com.example.demomvp.data.source.repository

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.ChampionDataSource
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

class ChampionRepository private constructor(
    private val remote: ChampionDataSource.Remote,
    private val local: ChampionDataSource.Local
) {

    fun getChampion(listener: OnFetchDataJsonListener<MutableList<Champion>>) {
        remote.getChampions(listener)
    }

    companion object {
        @Volatile
        private var mInstance: ChampionRepository? = null

        fun getRepository(
            remote: ChampionDataSource.Remote,
            local: ChampionDataSource.Local
        ): ChampionRepository =
            mInstance ?: synchronized(this) {
                val newInstance =
                    mInstance ?: ChampionRepository(remote, local).also { mInstance = it }
                newInstance
            }
    }
}
