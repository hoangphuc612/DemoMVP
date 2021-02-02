package com.example.demomvp.data.source.repository

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener

interface ChampionDataSource {
    /**
     * Local
     */
    interface Local

    /**
     * Remote
     */
    interface Remote {
        fun getChampions(listener: OnFetchDataJsonListener<MutableList<Champion>>)
    }
}
