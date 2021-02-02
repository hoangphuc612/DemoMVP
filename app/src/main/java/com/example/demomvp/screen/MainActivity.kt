package com.example.demomvp.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demomvp.R
import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.source.repository.ChampionRepository
import com.example.demomvp.screen.adapter.MainAdapter
import com.example.demomvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<Champion> {

    private val adapter: MainAdapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initView() {
        recyclerViewChampion.setHasFixedSize(true)
        recyclerViewChampion.adapter = adapter
        adapter.registerItemRecyclerViewClickListener(this)
    }

    private fun initData() {
        MainPresenter(ChampionRepository.instance).apply {
            setView(this@MainActivity)
            onStart()
        }
    }

    override fun onGetChampionSuccess(champions: MutableList<Champion>) {
        adapter.updateData(champions)
    }

    override fun onGetChampionError(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClickListener(item: Champion?) {
        Toast.makeText(this, item?.name, Toast.LENGTH_SHORT).show()
    }
}
