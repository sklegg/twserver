package sklegg.server

import sklegg.game.Game
import java.io.IOException
import java.net.Socket

/**
 * Created by scott on 12/23/16.
 * Communicates between Socket and game Protocol
 */
class ClientWorker (var clientSocket: Socket, var game: Game): Runnable {

    override fun run() {
        try {

            val inputStream = clientSocket.inputStream
            var status: Boolean = true

            val protocol = Protocol(game)

            while (clientSocket.isConnected && status) {
                var result: ProtocolResult?

                val inputBytes: ByteArray = ByteArray(36)
                inputStream.read(inputBytes)
                val clientMessage = kotlin.text.String(inputBytes)

                result = protocol.processInputFromClient(clientMessage)
                status = result.status
                val x = result.message
                println("ClientWorker - message: $x")
                val y = clientSocket.isConnected
                println("ClientWorker - clientSocket.isConnected? $y")
                clientSocket.outputStream.write(result.message.toByteArray())
            }

            inputStream.close()

            println("ClientWorker - socket closed. logout or protocol error")
        } catch (e: IOException) {
            println("ClientWorker - something happened")
            println(e.message)
            e.printStackTrace()
        }
    }
}