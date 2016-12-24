package sklegg.server

/**
 * Created by scott on 12/24/16.
 * Handles client requests
 */
class Protocol {

    // TODO: make this do something
    fun processInputFromClient(input: String) : String {
        if (input.startsWith("port:")) {
            /* send port info */
            return "info about a port"
        } else if (input.startsWith("sector:")) {
            /* send sector info */
            return "info about a sector"
        }
        return "__PROTOCOL_ERROR__"
    }
}