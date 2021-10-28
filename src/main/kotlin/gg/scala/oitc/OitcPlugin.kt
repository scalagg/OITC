package gg.scala.oitc

import gg.scala.commons.ExtendedScalaPlugin
import gg.scala.lemon.Lemon
import gg.scala.oitc.game.OitcGame
import gg.scala.oitc.player.adapter.OitcPlayerAdapter
import gg.scala.peanut.game.GameSettings
import net.evilblock.cubed.command.manager.CubedCommandManager
import org.bukkit.ChatColor

/**
 * @author puugz
 * @since 28/10/2021 02:36
 */
class OitcPlugin : ExtendedScalaPlugin() {

    companion object {
        @JvmStatic
        lateinit var instance: OitcPlugin
    }

    lateinit var game: OitcGame

    override fun enable() {
        instance = this

        val commandManager = loadCommands()
        val settings = GameSettings().also {
            it.name = "OITC"
        }

        game = OitcGame(settings)
        game.registerGame(this, commandManager, OitcPlayerAdapter())
    }

    private fun loadCommands(): CubedCommandManager {
        return CubedCommandManager(
            plugin = this,
            primary = ChatColor.valueOf(Lemon.instance.lemonWebData.primary),
            secondary = ChatColor.valueOf(Lemon.instance.lemonWebData.secondary)
        ).also {
            Lemon.instance.registerCompletionsAndContexts(it)
//            Lemon.instance.registerCommandsInPackage(it, "gg.scala.oitc.command")
        }
    }
}