package sklegg.gameobjects

import sklegg.gameobjects.planets.AbstractPlanet
import sklegg.gameobjects.ships.AbstractShip

/**
 * Created by scott on 12/22/16.
 * One sector in the universe
 */
class Sector (sectorNumber: Int){
    var sectorNumber: Int = 0
    var regionName: String = ""
    var port: Port? = null
    var ships: Array<AbstractShip> = emptyArray()
    var neighbors: Array<Sector> = emptyArray()
    var planets: Array<AbstractPlanet> = emptyArray()
    var beacon: Beacon? = null

    // mines
    // fighters

    private fun bag(): String {
        return this.regionName + this.beacon.toString()
    }

}