package gg.scala.oitc.player.board

import gg.scala.oitc.OitcPlugin
import gg.scala.oitc.game.GameState
import gg.scala.peanut.player.board.GameScoreboard
import net.evilblock.cubed.util.CC
import org.bukkit.entity.Player
import java.util.*

/**
 * @author puugz
 * @since 28/10/2021 04:30
 */
class ScoreboardProvider : GameScoreboard() {

    override fun getLines(board: LinkedList<String>, player: Player) {
        val game = OitcPlugin.instance.game
        val gamePlayer = game.getGamePlayer(player)!!
        val remaining = game.remaining().size

        board.add("${CC.GRAY + CC.S}--------------------")
        when (game.state) {
            GameState.WAITING -> {
                board.add("Waiting for players...")

                if (remaining < game.settings.minPlayers) {
                    val more = game.settings.minPlayers - remaining
                    board.add("${CC.PRI + more + CC.WHITE} more player${if (more == 1) "" else "s"}.")
                }
            }
            GameState.STARTING -> {
                board.add("Starting in: ${CC.PRI + game.startTime}")
            }
            GameState.IN_GAME -> {
                board.add("Remaining: ${CC.PRI + remaining}/${game.initial}")
                board.add("Kills: ${CC.PRI + gamePlayer.kills}/50")
                board.add("Deaths: ${CC.PRI + gamePlayer.deaths}")
                board.add("Respawns: ${CC.PRI + gamePlayer.respawnsLeft}/10")
            }
            GameState.ENDED -> {
                board.add("Winner:")
                board.add("${CC.PRI + game.winner}")
            }
        }
        board.add("")
        board.add("${CC.SEC}www.pvp.bar")
        board.add("${CC.GRAY + CC.S}--------------------")
    }
}