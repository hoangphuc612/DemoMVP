package com.example.demomvp.data.source.remote.fetchJson

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.model.ChampionEntry
import com.example.demomvp.utils.Constant
import org.json.JSONObject

class ParseJson {

    fun championParseJson(jsonObject: JSONObject): Champion {
        val name = jsonObject.getString(ChampionEntry.NAME)
        val imageObject = jsonObject.getJSONObject(ChampionEntry.URL_IMAGE)
        val image = imageObject.getString(ChampionEntry.FULL_IMAGE)
        val stats = jsonObject.getJSONObject(ChampionEntry.STATS)
        val attack = stats.getInt(ChampionEntry.ATTACK)
        val armor = stats.getInt(ChampionEntry.ARMOR)
        val hp = stats.getInt(ChampionEntry.HP)
        val convertImage = Constant.BASE_URL_IMAGE + image.replace(Constant.PNG_IMAGE, Constant.CONVERT_IMAGE)
        return Champion(name, convertImage, attack, hp, armor)
    }
}
