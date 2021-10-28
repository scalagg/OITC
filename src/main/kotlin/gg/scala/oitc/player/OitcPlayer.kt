package gg.scala.oitc.player

import gg.scala.peanut.player.type.KillableGamePlayer
import java.util.*

/**
 * @author puugz
 * @since 28/10/2021 02:52
 */
class OitcPlayer(uniqueId: UUID, name: String) : KillableGamePlayer(uniqueId, name) {

    val respawnsLeft = 5

}