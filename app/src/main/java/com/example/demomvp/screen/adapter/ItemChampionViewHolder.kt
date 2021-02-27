package com.example.demomvp.screen.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.data.model.Champion
import com.example.demomvp.utils.LoadImageBitmap
import kotlinx.android.synthetic.main.item_layout_champion.view.*

class ItemChampionViewHolder(
    itemView: View,
    private var itemListener: (Champion) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bindViewData(champion: Champion) = with(itemView) {
        textViewName.text = champion.name
        textViewAttack.text = champion.attack.toString()
        textViewHp.text = champion.hp.toString()
        textViewArmor.text = champion.armor.toString()
        setOnClickListener {
            itemListener(champion)
        }
        getImage(champion)
    }

    private fun getImage(champion: Champion) {
        @Suppress("DEPRECATION")
        LoadImageBitmap(itemView.imageChampion).execute(champion.urlImage)
    }
}
