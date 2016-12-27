package sklegg.server

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol {

    // TODO: inject an object with references to ports, sectors, user accounts, planets, etc.?
    fun processInputFromClient(input: String) : ProtocolResult {
        println("Protocol - input: $input")

        if (input.startsWith("port::")) {
            /* send port info */
            return ProtocolResult(true, "info about a port")
        } else if (input.startsWith("sector::")) {
            /* send sector info */
            return ProtocolResult(true, "info about a sector")
        } else if (input.startsWith("init::")) {
            /* log in */
            return ProtocolResult(true, "acknowledge login")
        }
        return ProtocolResult(false, "Protocol Error.")
    }
}