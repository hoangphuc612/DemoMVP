package com.example.demomvp.screen

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.remote.OnFetchDataJsonListener
import com.example.demomvp.data.source.repository.ChampionRepository
import java.lang.Exception

class MainPresenter internal constructor(private val repository: ChampionRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun onStart() {
        getChampions()
    }

    override fun onStop() {}

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getChampions() {
        repository?.getChampion(object : OnFetchDataJsonListener<MutableList<Champion>> {
            override fun onSuccess(data: MutableList<Champion>) {
                view?.onGetChampionSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onGetChampionError(exception)
            }
        })
    }
}
