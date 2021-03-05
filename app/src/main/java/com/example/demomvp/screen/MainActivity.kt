package com.example.demomvp.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.demomvp.R
import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.local.ChampionLocalDataSource
import com.example.demomvp.data.source.remote.ChampionRemoteDataSource
import com.example.demomvp.data.source.remote.fetchJson.ParseDataWithJson
import com.example.demomvp.data.source.repository.ChampionRepository
import com.example.demomvp.screen.adapter.ChampionAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View {

    private val championAdapter by lazy {
        ChampionAdapter {
            onItemClickListener(it)
        }
    }

    private fun onItemClickListener(champion: Champion) {
        Toast.makeText(this, champion.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
        
    }

    private fun initView() {
        recyclerViewChampion.apply {
            adapter = championAdapter
            setHasFixedSize(true)
        }
    }

    private fun initData() {
        MainPresenter(
            ChampionRepository.getRepository(
                ChampionRemoteDataSource.getRemote(),
                ChampionLocalDataSource.getLocal()
            )
        ).apply {
            setView(this@MainActivity)
            getChampions()
        }
    }

    override fun onGetChampionSuccess(champions: MutableList<Champion>) {
        championAdapter.updateData(champions)
    }

    override fun onError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }
}
