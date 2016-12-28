package sklegg.server

import sklegg.game.Game

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol(var game: Game) {

    fun processInputFromClient(input: String) : ProtocolResult {
        println("Protocol - input: $input")

        val commandParts = getCommandParts(input)
        printCommandList(commandParts)

        if ("sector" == commandParts[0]) {
            /* send sector info */
            val sector = game.map.sectors[2]
            return ProtocolResult(true, sector.serialize())
        } else if ("port" == commandParts[0]) {
            /* send port info */
            return ProtocolResult(true, "info about a port")
        } else if ("init" == commandParts[0]) {
            /* log in */
            return ProtocolResult(true, "acknowledge login")
        } else if ("user" == commandParts[0]) {
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