package com.example.demomvp.data.model

data class Champion(
    val name: String = "",
    val urlImage: String = "",
    val attack: Int = 0,
    val hp: Int = 0,
    val armor: Int = 0
)

object ChampionEntry {
    const val NAME = "name"
    const val URL_IMAGE = "image"
    const val FULL_IMAGE = "full"
    const val STATS = "stats"
    const val ATTACK = "attackdamage"
    const val CHAMPION = "data"
    const val HP = "hp"
    const val ARMOR = "armor"
}
