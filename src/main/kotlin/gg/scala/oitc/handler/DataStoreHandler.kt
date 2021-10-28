package gg.scala.oitc.handler

import com.solexgames.datastore.commons.connection.impl.mongo.UriMongoConnection
import com.solexgames.datastore.commons.layer.impl.MongoStorageLayer
import com.solexgames.datastore.commons.storage.impl.MongoStorageBuilder
import gg.scala.lemon.Lemon
import gg.scala.oitc.player.OitcPlayer
import net.evilblock.cubed.serializers.Serializers

/**
 * @author puugz
 * @since 28/10/2021 03:16
 */
object DataStoreHandler {

    var gamePlayerLayer: MongoStorageLayer<OitcPlayer>

    init {
        val mongoConnection = UriMongoConnection(Lemon.instance.mongoConfig.uri)
        val database = Lemon.instance.mongoConfig.database

        this.gamePlayerLayer = MongoStorageBuilder<OitcPlayer>()
            .setDatabase(database).setCollection("oitc_players")
            .setConnection(mongoConnection).setType(OitcPlayer::class.java).build()

        this.gamePlayerLayer.supplyWithCustomGson(Serializers.gson)
    }
}