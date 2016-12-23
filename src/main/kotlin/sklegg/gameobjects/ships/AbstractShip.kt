package sklegg.gameobjects.ships

/**
 * Created by scott on 12/20/16.
 * Abstract Ship
 */
abstract class AbstractShip constructor() {

    abstract var shipName: String
    abstract var manufacturer: String

    abstract var atomicDetonators: Int
    abstract var markerBeacons: Int
    abstract var corbomite: Int
    abstract var cloakingDevices: Int
    abstract var armidMines: Int
    abstract var etherProbes: Int
    abstract var limpitMines: Int
    abstract var photonMissiles: Int
    abstract var hasPlanetScanner: Boolean
    abstract var numFighters: Int
    abstract var numHolds: Int
    abstract var numGenesisTorpedoes: Int
    abstract var numMineDisruptors: Int
    abstract var numShields: Int
    abstract var hasTranswarpDrive: Boolean
    abstract var hasPsychicProbe: Boolean

    abstract val shipType: String
    abstract val purchaseCost: Int
    abstract val maxAtomicDetonators: Int
    abstract val maxMarkerBeacons: Int
    abstract val maxCorbomite: Int
    abstract val maxCloaking: Int
    abstract val maxEtherProbes: Int
    abstract val planetScanner: Boolean
    abstract val turnsPerWarp: Int
    abstract val maxLimpitMines: Int
    abstract val maxArmidMines: Int
    abstract val maxPhotonMissiles: Int

    abstract val longRangeScanner: String
    abstract val maxMineDisrupters: Int
    abstract val maxGenesisTorpedoes: Int
    abstract val offensiveShipOdds: Int
    abstract val defensiveShipOdds: Int
    abstract val transwarpDrive: Boolean
    abstract val psychicProbe: Boolean
    abstract val maxHolds: Int
    abstract val maxFighters: Int
    abstract val maxShields: Int
    abstract val maxFightersPerAttack: Int
    abstract val transportRange: Int
    abstract val shipValue: String

}