package com.example.demomvp.screen

import com.example.demomvp.data.model.Champion
import com.example.demomvp.utils.BasePresenter
import java.lang.Exception

interface MainContract {
    /**
     * View
     */
    interface View {
        fun onGetChampionSuccess(champions: MutableList<Champion>)
        fun onError(exception: Exception?)
    }

    /**
     * Presenter
     */
    interface Presenter : BasePresenter<View> {
        fun getChampions()
    }
}
