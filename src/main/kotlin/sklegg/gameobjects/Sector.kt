package sklegg.gameobjects

import com.github.salomonbrys.kotson.toJson
import com.google.gson.JsonObject
import sklegg.gameobjects.planets.AbstractPlanet
import sklegg.gameobjects.ships.AbstractShip

/**
 * Created by scott on 12/22/16.
 * One sector in the universe
 */
class Sector (var sectorNumber: Int){
    var regionName: String = ""
    var port: Port? = null
    var ships: Array<AbstractShip> = emptyArray()
    var neighbors: Array<Sector> = emptyArray()
    var planets: Array<AbstractPlanet> = emptyArray()
    var beacon: Beacon? = null

    // mines
    // fighters

    fun serialize(): String {
        val result = JsonObject()
        result.add("id", sectorNumber.toJson())
        result.add("name", regionName.toJson())
        //result.add("neighbors", jsonArray(neighbors))
        return result.toString()
    }
}