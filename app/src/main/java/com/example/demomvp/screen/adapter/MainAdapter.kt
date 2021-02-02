package com.example.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Champion
import com.example.demomvp.utils.LoadImageBitmap
import com.example.demomvp.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.item_layout_champion.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val champions = mutableListOf<Champion>()
    private var onItemClickListener: OnItemRecyclerViewClickListener<Champion>? = null

    fun updateData(champions: MutableList<Champion>?) {
        champions?.let {
            this.champions.clear()
            this.champions.addAll(champions)
            notifyDataSetChanged()
        }
    }

    fun registerItemRecyclerViewClickListener(
            onItemRecyclerViewClickListener: OnItemRecyclerViewClickListener<Champion>?) {
        onItemClickListener = onItemRecyclerViewClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_layout_champion, parent, false)
        return ViewHolder(view, onItemClickListener)
    }

    override fun getItemCount(): Int {
        return champions.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bindViewData(champions[position])
    }

    inner class ViewHolder(itemView: View, private val itemListener: OnItemRecyclerViewClickListener<Champion>?) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var listener: OnItemRecyclerViewClickListener<Champion>? = null

        fun bindViewData(champion: Champion) {
            itemView.textViewName.text = champion.name
            itemView.textViewAttack.text = champion.attack.toString()
            itemView.textViewArmor.text = champion.armor.toString()
            itemView.textViewHp.text = champion.hp.toString()
            itemView.setOnClickListener(this)
            listener = itemListener
            getImage(champion)
        }

        private fun getImage(champion: Champion) {
            @Suppress("DEPRECATION")
            LoadImageBitmap(itemView.imageChampion).execute(champion.urlImage)
        }

        override fun onClick(v: View?) {
            listener?.onItemClickListener(champions[adapterPosition])
        }
    }
}
