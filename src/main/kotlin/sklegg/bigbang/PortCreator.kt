package sklegg.bigbang

import sklegg.gameobjects.Port
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by scott on 12/23/16.
 * Generates a random port
 */
fun generateRandomPort(sectorNumber: Int): Port {
    // randomize class
    var randomPortClass: Int = ThreadLocalRandom.current().nextInt(1, 9)

    return Port(sectorNumber, generatePortName(), randomPortClass)
}

fun generatePortName(): String {
    val names = arrayOf("Bourbon","Kirk","Turkington","Roast Beef", "Zero Cool", "Crash Override", "Acid Burn")
    var suffix = arrayOf("Annex", "III", "Prime", "Nova", "Tactical", "Major", "One")
    val randomNameIndex = ThreadLocalRandom.current().nextInt(1, names.size)
    val randomSuffixIndex = ThreadLocalRandom.current().nextInt(1, names.size)
    return names[randomNameIndex] + " " + suffix[randomSuffixIndex]
}