package sklegg.gameobjects

import com.github.salomonbrys.kotson.toJson
import com.google.gson.JsonElement

/**
 * Created by scott on 12/23/16.
 * Beacons can be added to any port to display a message
 */

class Beacon(var message: String = "") {
    fun toJson() : JsonElement {
        return message.toJson()
    }
}