package com.example.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Champion

class ChampionAdapter(
    private var onItemClickListener: (Champion) -> Unit
) : RecyclerView.Adapter<ItemChampionViewHolder>() {

    private val champions = mutableListOf<Champion>()

    fun updateData(champions: MutableList<Champion>?) {
        champions?.let {
            this.champions.clear()
            this.champions.addAll(champions)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemChampionViewHolder =
        ItemChampionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout_champion,parent,false),
            onItemClickListener
        )

    override fun getItemCount() = champions.size

    override fun onBindViewHolder(holderItemChampion: ItemChampionViewHolder, position: Int) =
        holderItemChampion.bindViewData(champions[position])
}
