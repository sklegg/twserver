package sklegg.server

import com.github.salomonbrys.kodein.*
import sklegg.game.Game

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol() : KodeinInjected {

    override val injector = KodeinInjector()
    val game: Game by instance("gameDI")

    fun processInputFromClient(input: String) : ProtocolResult {
        println("Protocol - input: $input")

        val commandParts = getCommandParts(input)
        printCommandList(commandParts)

        if ("sector".equals(commandParts[0])) {
            /* send sector info */
            val sectorNumber = commandParts[2].trim()
            val requestedPort = game.map.sectors[sectorNumber.toInt()]
            return ProtocolResult(true, requestedPort.toString())
        } else if ("port".equals(commandParts[0])) {
            /* send port info */
            return ProtocolResult(true, "info about a port")
        } else if ("init".equals(commandParts[0])) {
            /* log in */
            return ProtocolResult(true, "acknowledge login")
        } else if ("user".equals(commandParts[0])) {
            return ProtocolResult(true, "info about a player")
        }
        return ProtocolResult(false, "Protocol Error.")
    }

    /* TODO: move to new command class */
    private fun getCommandParts(command: String) : List<String> {
        return command.split(':')
    }

    private fun printCommandList(list: List<String>) {
        list.forEach { n -> println(n)}
    }
}