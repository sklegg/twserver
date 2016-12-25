package sklegg.server

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol {

    // TODO: make this do something
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