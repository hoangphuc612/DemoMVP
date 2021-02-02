package com.example.demomvp.data.source.local

import com.example.demomvp.data.source.repository.ChampionDataSource

class ChampionLocalDataSource : ChampionDataSource.Local {

    private object Holder {
        val INSTANCE = ChampionLocalDataSource()
    }

    companion object {
        val instance: ChampionLocalDataSource by lazy { Holder.INSTANCE }
    }
}
