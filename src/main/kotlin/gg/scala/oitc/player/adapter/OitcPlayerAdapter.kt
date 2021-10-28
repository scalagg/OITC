package gg.scala.oitc.player.adapter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import gg.scala.oitc.player.OitcPlayer
import gg.scala.peanut.player.adapter.GamePlayerAdapter
import java.lang.reflect.Type

/**
 * @author puugz
 * @since 28/10/2021 03:01
 */
class OitcPlayerAdapter : GamePlayerAdapter<OitcPlayer>() {

    override fun serialize(src: OitcPlayer?, type: Type?, context: JsonSerializationContext?): JsonElement {
        TODO()
    }

    override fun deserialize(json: JsonElement?, type: Type?, context: JsonDeserializationContext?): OitcPlayer {
        TODO()
    }

    override fun getPlayerClass(): Class<OitcPlayer> {
        return OitcPlayer::class.java
    }
}