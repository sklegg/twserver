package sklegg.gameobjects.planets

import sklegg.gameobjects.Citadel

/**
 * Created by scott on 12/22/16.
 * Abstract Planet type
 */

abstract class AbstractPlanet {
    abstract var planetClass: String
    abstract var description: String
    abstract var value: String

    abstract var maxFuelOrePopulation: Int
    abstract var maxOrganicsPopulation: Int
    abstract var maxEquipmentPopulation: Int
    abstract var maxFuelOreCapacity: Int
    abstract var maxOrganicsCapacity: Int
    abstract var maxEquipmentCapacity: Int
    abstract var currentFuelOre: Int
    abstract var currentOrganics: Int
    abstract var currentEquipment: Int
    abstract var fuelOreColonistsNeeded: Int
    abstract var organicsColonistsNeeded: Int
    abstract var equipmentColonistsNeeded: Int

    abstract var currentColonists: Int
    abstract var currentFighters: Int

    abstract var citadel: Citadel

    abstract fun nightlyMaint() // do planet stuff

}