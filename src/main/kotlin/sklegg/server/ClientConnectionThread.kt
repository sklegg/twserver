package sklegg.server

import java.net.ServerSocket
import java.util.concurrent.Executors
import java.io.IOException
import java.net.Socket


/**
 * Created by scott on 12/23/16.
 * Runnable for managing client connections
 */

class ClientConnectionThread (val serverPort: Int, val numConnections: Int) : Runnable {
    var serverSocket: ServerSocket? = null
    var stopping: Boolean = false
    var runningThread: Thread? = null
    var threadPool = Executors.newFixedThreadPool(numConnections)

    init {
        println("Created ClientConnectionThread")
    }

    override fun run() {

        synchronized(this) {
            this.runningThread = Thread.currentThread()
        }

        openServerSocket()

        while(!stopping) {
            var clientSocket: Socket

            try {
                clientSocket = this.serverSocket!!.accept()
            } catch (ex: IOException) {
                if (isStopped()) {
                    println("Server Stopped.")
                    break
                }

                throw RuntimeException("Error accepting client connection", ex)
            }

            this.threadPool.execute(ClientWorker(clientSocket))
        }

        this.threadPool.shutdown()
        println("ClientConnectionThread has shut down")

    }

    @Synchronized
    private fun isStopped(): Boolean {
        return this.stopping
    }

    @Synchronized
    fun stop() {
        this.stopping = true
        try {
            this.serverSocket!!.close()
        } catch (e: IOException) {
            throw RuntimeException("Error stopping ClientConnectionThread", e)
        }
    }

    private fun openServerSocket() {
        try {
            this.serverSocket = ServerSocket(this.serverPort)
        } catch (e: IOException) {
            throw RuntimeException("Cannot open port $this.serverPort", e)
        }
    }
}