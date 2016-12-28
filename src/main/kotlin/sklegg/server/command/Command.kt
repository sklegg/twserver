package sklegg.server.command

/**
 * Created by scott on 12/27/16.
 * Base class for user commands
 */
class Command(val commandString: String) {

    private var commandParts: List<String> = emptyList()

    init {
        commandParts = splitString()
    }

    fun getCommandType(): String {
        return commandParts[0]
    }

    private fun splitString(): List<String> {
        return commandString.split(":")
    }
}