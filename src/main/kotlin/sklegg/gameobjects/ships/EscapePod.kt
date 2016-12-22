package sklegg.gameobjects.ships

import sklegg.gameobjects.AbstractShip

/**
 * Created by scott on 12/20/16.
 * Escape pod ship
 */
class EscapePod : AbstractShip() {

    /* what are initial values for new ships? */
    /* move to constructor? */
    override var shipName: String = ""

    override var atomicDetonators: Int = 0
    override var markerBeacons: Int = 0
    override var corbomite: Int = 0
    override var cloakingDevices: Int = 0
    override var armidMines: Int = 0
    override var etherProbes: Int = 0
    override var limpitMines: Int = 0
    override var photonMissiles: Int = 0
    override var hasPlanetScanner: Boolean = false
    override var numFighters: Int = 0
    override var numHolds: Int = 0
    override var numGenesisTorpedoes: Int = 0
    override var numMineDisruptors: Int = 0
    override var numShields: Int = 0
    override var hasTranswarpDrive: Boolean = false
    override var hasPsychicProbe: Boolean = false



    override val shipType: String
        get() = "Escape Pod"

    override val purchaseCost: Int
        get() = 0

    override val maxAtomicDetonators: Int
        get() = 5

    override val maxMarkerBeacons: Int
        get() = 0

    override val maxCorbomite: Int
        get() = 1500

    override val maxCloaking: Int
        get() = 5

    override val maxArmidMines: Int
        get() = 0

    override val maxEtherProbes: Int
        get() = 25

    override val maxLimpitMines: Int
        get() = 0

    override val maxPhotonMissiles: Int
        get() = 0

    override val planetScanner: Boolean
        get() = false

    override val turnsPerWarp: Int
        get() = 6

    override val defensiveShipOdds: Int
        get() = 8

    override val longRangeScanner: String
        get() = "Holo"

    override val maxFighters: Int
        get() = 50

    override val maxFightersPerAttack: Int
        get() = 10

    override val maxGenesisTorpedoes: Int
        get() = 0

    override val maxHolds: Int
        get() = 5

    override val maxMineDisrupters: Int
        get() = 10

    override val maxShields: Int
        get() = 50

    override val offensiveShipOdds: Int
        get() = 8

    override val psychicProbe: Boolean
        get() = false

    override val shipValue: String
        get() = "Low"

    override val transportRange: Int
        get() = 0

    override val transwarpDrive: Boolean
        get() = false



}