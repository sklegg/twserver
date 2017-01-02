package sklegg.server.command

/**
 * Created by scott on 12/27/16.
 * Base class for user commands
 */
class Command(val commandString: String) {

    private var commandParts: List<String> = emptyList()
    private val TYPE = 0
    private val SECTOR = 1

    init {
        commandParts = splitString()
    }

    fun getCommandType(): String {
        return commandParts[TYPE]
    }

    fun getSectorNumber(): Int {
        /*println(commandParts[SECTOR])
        println(commandParts[SECTOR].length)
        println(commandParts[SECTOR].replace(" ",""))
        println(commandParts[SECTOR].replace(" ","").length)*/
        return commandParts[SECTOR].toInt()
    }

    fun getCommandParts() : List<String> {
        return commandParts
    }

    private fun splitString(): List<String> {
        /* FIXME */
        return commandString.replace(" ","").split(":")
    }

    private fun printCommandList(list: List<String>) {
        list.forEach { n -> println(n)}
    }
}