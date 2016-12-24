package sklegg.server

import java.net.Socket
import com.sun.xml.internal.ws.streaming.XMLStreamWriterUtil.getOutputStream
import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
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
                        /* read all of clients message at once. Kotlin is Kool */
            val clientMessage = clientSocket.inputStream.bufferedReader().use { it.readText() }

            /* now let the Protocol handle the request */
            clientSocket.outputStream.bufferedWriter().write(Protocol().processInputFromClient(clientMessage))

            /*output.close()
            input.close()*/

            println("ClientWorker - sent reply to client")
        } catch (e: IOException) {
            println("ClientWorker - something happened")
            println(e.message)
        }
    }
}