package sklegg.server

import java.net.Socket
import java.io.IOException

/**
 * Created by scott on 12/23/16.
 * Communicates between Socket and game Protocol
 */
class ClientWorker (var clientSocket: Socket): Runnable {

    init {
        println("Created ClientWorker")
    }

    override fun run() {
        try {

            var inputStream = clientSocket.inputStream
            var status: Boolean = true

            val protocol = Protocol()

            while (clientSocket.isConnected && status) {
                var result: ProtocolResult? = null

                var inputBytes: ByteArray = ByteArray(128)
                inputStream.read(inputBytes)
                var inputSize = inputBytes.size
                println("read $inputSize bytes")
                var clientMessage = kotlin.text.String(inputBytes)
                clientMessage = clientMessage.trim()
                println(clientMessage)

                result = protocol.processInputFromClient(clientMessage)
                status = result.status
                val x = result.message
                println("ClientWorker - $x")
                val y = clientSocket.isConnected
                println("ClientWorker - isConnected? $y")
            }

            /* read all of clients message at once. Kotlin is Kool */
            //val clientMessage = clientSocket.inputStream.bufferedReader().use { it.readText() }
            //println("ClientWorker - rec'd from client: $clientMessage")

            /* now let the Protocol handle the request */
            //clientSocket.outputStream.bufferedWriter().write(Protocol().processInputFromClient(clientMessage))

            /*output.close()*/
            inputStream.close()

            println("ClientWorker - socket closed. logout or protocol error")
        } catch (e: IOException) {
            println("ClientWorker - something happened")
            println(e.message)
            e.printStackTrace()
        }
    }
}