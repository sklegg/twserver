package sklegg.server

import sklegg.game.Game
import sklegg.server.command.Command

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol(var game: Game) {

    fun processInputFromClient(input: String) : ProtocolResult {
        println("Protocol - input: $input")

        val command = Command(input)

        if ("sector" == command.getCommandType()) {
            /* send sector info */
            val sectorNumber = command.getSectorNumber()
            val sector = game.map.sectors[sectorNumber]
            return ProtocolResult(true, sector.serialize())
        } else if ("port" == command.getCommandType()) {
            /* send port info */
            val sectorNumber = command.getSectorNumber()
            val port = game.map.sectors[sectorNumber].port
            if (port != null) {
                return ProtocolResult(true, port.serialize())
            } else {
                return ProtocolResult(false, "Port not found in sector 2")
            }
        } else if ("init" == command.getCommandType()) {
            /* log in */
            return ProtocolResult(true, "acknowledge login")
        } else if ("user" == command.getCommandType()) {
            return ProtocolResult(true, "info about a player")
        }

        return ProtocolResult(false, "Protocol Error.")
    }
}