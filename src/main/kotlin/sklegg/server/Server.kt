package sklegg.server

import com.natpryce.konfig.*

/**
 * Created by scott on 12/21/16.
 * Server application entry point
 */

fun main(args : Array<String>) {
    val config = ConfigurationProperties.fromResource("server.properties")
    val port = config[Key("server.port", intType)]
    val threads = config[Key("server.threads", intType)]

    val connections = ClientConnectionThread(port, threads)
    print("Starting server on port $port with $threads threads.    ")
    Thread(connections).start()
    println(" OK!")
}