package gg.scala.oitc.game

import gg.scala.oitc.player.OitcPlayer
import gg.scala.peanut.game.Game
import gg.scala.peanut.game.GameSettings
import gg.scala.peanut.game.type.Respawnable
import gg.scala.peanut.game.type.Spectatable
import net.evilblock.cubed.util.CC
import net.evilblock.cubed.util.bukkit.ItemBuilder
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.PlayerDeathEvent
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.collections.HashSet

/**
 * @author puugz
 * @since 28/10/2021 02:52
 */
class OitcGame(
    settings: GameSettings,
    override var respawning: HashSet<UUID> = HashSet(),
    override var spectators: HashSet<UUID> = HashSet()
) : Game<OitcPlayer, GameState>(settings), Respawnable, Spectatable {

    lateinit var spawnLocation: Location
    val spawnLocations = arrayListOf<Location>()

    var winner = "No-one"

    init {
        // load spawnLocations from config.yml or something
    }

    override fun handleReady() {
        // teleport to arena
        // handle kit
    }

    override fun handleStarted() {
        // called when the game starts
    }

    override fun handleEnding() {
        // called when the game ends
        // (unimplemented atm)
    }

    override fun checkWinners() {
        // called every second
        // you check for winners and foreach
        // you call the handleWinner function
    }

    override fun handlePlayerDeath(event: PlayerDeathEvent, gamePlayer: OitcPlayer, gamePlayerKiller: OitcPlayer?) {

    }

    override fun getSpawnPoint(gamePlayer: OitcPlayer): Location {
        return spawnLocations[ThreadLocalRandom.current().nextInt(spawnLocations.size)]
    }

    override fun handleInventory(player: Player) {
        // called when a player joins the game

        player.inventory.setItem(8,
            ItemBuilder(Material.BED)
                .name("${CC.RED}Back to Hub")
                .build()
        )
        player.updateInventory()
    }

    override fun handleWinner(winner: OitcPlayer) {

    }

    override fun getRespawnPoint(player: Player): Location {
        return Bukkit.getWorlds()[0].spawnLocation.clone()
    }

    override fun handleRespawn(player: Player) {

    }

    override fun getSpectatorSpawnPoint(): Location {
        return Bukkit.getWorlds()[0].spawnLocation.clone().add(0.0, 50.0, 0.0)
    }

    override fun remaining(): List<Player> {
        TODO("Not yet implemented")
    }

    override fun getLobbyServer(): String {
        return "na-hub-4"
    }

    override fun canStart(): Boolean {
        return remaining().size >= settings.minPlayers
    }
}
