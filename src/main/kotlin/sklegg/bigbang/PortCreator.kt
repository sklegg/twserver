package sklegg.bigbang

import sklegg.gameobjects.Port
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by scott on 12/23/16.
 * Generates a random port
 */
fun generateRandomPort(sectorNumber: Int): Port {
    // randomize name
    var randomName: String = "name"

    // randomize class
    var randomPortClass: Int = ThreadLocalRandom.current().nextInt(1, 9);

    return Port(sectorNumber, randomName, randomPortClass)
}