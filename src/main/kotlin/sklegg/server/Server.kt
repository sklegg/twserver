package sklegg.server

import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.Key
import com.natpryce.konfig.intType
import sklegg.bigbang.MapCreator
import sklegg.game.Game
import sklegg.game.GameConfig
import sklegg.gameobjects.Player

/**
 * Created by scott on 12/21/16.
 * Server application entry point
 */
class Server() {
    /* TODO: clean this up and make null-safe */
    private var port: Int? = null
    private var threads: Int? = null

    fun start() {

        /* TODO: read game state from disk/db instead of generating on startup */
        val gameConfig = getGameConfig()
        val game = Game(MapCreator().generateNewMap(gameConfig.numSectors), generateDefaultPlayerArray())

        println("Server - sector length = " + game.map.sectors.size)

        readServerConfig()
        val connections = ClientConnectionThread(port!!, threads!!, game)

        print("Starting server on port $port with $threads threads.    ")
        Thread(connections).start()
        println(" OK!")
    }

    private fun readServerConfig() {
        val config = ConfigurationProperties.fromResource("server.properties")
        port = config[Key("server.port", intType)]
        threads = config[Key("server.threads", intType)]
    }

    private fun getGameConfig(): GameConfig {
        val config = ConfigurationProperties.fromResource("game.properties")
        val gameConfig = GameConfig()
        gameConfig.numSectors = config[Key("game.initialSectors", intType)]
        println("Server - got gameconfig: $gameConfig.numSectors")
        return gameConfig
    }

    private fun generateDefaultPlayerArray() : Array<Player> {
        val defaultPlayer = Player("scott")
        val players: Array<Player> = emptyArray()
        players.plus(defaultPlayer)
        return players
    }
}