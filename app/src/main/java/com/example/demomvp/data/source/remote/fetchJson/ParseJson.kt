package com.example.demomvp.data.source.remote.fetchJson

import com.example.demomvp.data.model.Champion
import com.example.demomvp.data.model.ChampionEntry
import com.example.demomvp.utils.Constant
import org.json.JSONObject

class ParseJson {

    fun championParseJson(jsonObject: JSONObject): Champion =
        jsonObject.run {
            val imageObject = getJSONObject(ChampionEntry.URL_IMAGE)
            val image = imageObject.getString(ChampionEntry.FULL_IMAGE)
            val stats = getJSONObject(ChampionEntry.STATS)
            Champion(
                getString(ChampionEntry.NAME),
                Constant.BASE_URL_IMAGE +
                    image.replace(Constant.PNG_IMAGE, Constant.CONVERT_IMAGE),
                stats.getInt(ChampionEntry.ATTACK),
                stats.getInt(ChampionEntry.HP),
                stats.getInt(ChampionEntry.ARMOR)
            )
        }
}
