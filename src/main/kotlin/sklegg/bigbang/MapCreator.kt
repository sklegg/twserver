package sklegg.bigbang

import sklegg.gameobjects.Beacon
import sklegg.gameobjects.Sector
import sklegg.gameobjects.UniverseMap

/**
 * Created by scott on 12/23/16.
 * Create Sector Map
 */
class MapCreator {

    fun generateNewMap(numSectors: Int): UniverseMap {
        // generate numSectors Sector objects
        val sectors: Array<Sector> = Array(numSectors, {i -> Sector(i)})
        val neighbors: Array<Int> = Array(numSectors, { i -> i + 1 })

        // create links between them
        sectors.forEach { s -> randomizeSector(s) }
        makeSomeWarpsToConnectSectors(sectors, neighbors)

        // add to UniverseMap
        return UniverseMap(sectors)
    }

    private fun randomizeSector(s: Sector) {
        s.port = generateRandomPort()

        if (s.sectorNumber <= 10) {
            s.beacon = Beacon("FedSpace: All Federation Rules Apply")
            s.regionName = "FedSpace"
        } else {
            s.regionName = "Delta Quadrant"
        }
    }

    private fun makeSomeWarpsToConnectSectors(sectors: Array<Sector>, neighbors: Array<Int>) {
        /* stub this for now. allow warps to all sectors */
        sectors.forEach { s -> run{ s.neighbors = neighbors}}
    }
}