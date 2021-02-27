package com.example.demomvp.data.source.local

import com.example.demomvp.data.source.ChampionDataSource

class ChampionLocalDataSource : ChampionDataSource.Local {

    companion object {
        @Volatile
        private var mInstance: ChampionLocalDataSource? = null

        fun getLocal(): ChampionLocalDataSource =
            mInstance ?: synchronized(this) {
                val newInstance =
                    mInstance ?: ChampionLocalDataSource().also { mInstance = it }
                newInstance
            }
    }
}
