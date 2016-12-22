package sklegg.gameobjects.ships

import sklegg.gameobjects.AbstractShip

/**
 * Created by scott on 12/21/16.
 * Merchant cruiser ship
 */

class MerchantCruiser : AbstractShip() {

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
        get() = "Merchant Cruiser"

    override val purchaseCost: Int
        get() = 41300

    override val maxAtomicDetonators: Int
        get() = 5

    override val maxMarkerBeacons: Int
        get() = 50

    override val maxCorbomite: Int
        get() = 1500

    override val maxCloaking: Int
        get() = 5

    override val maxArmidMines: Int
        get() = 50

    override val maxEtherProbes: Int
        get() = 25

    override val maxLimpitMines: Int
        get() = 50

    override val maxPhotonMissiles: Int
        get() = 0

    override val planetScanner: Boolean
        get() = true

    override val turnsPerWarp: Int
        get() = 3

    override val defensiveShipOdds: Int
        get() = 10

    override val longRangeScanner: String
        get() = "Holo"

    override val maxFighters: Int
        get() = 2500

    override val maxFightersPerAttack: Int
        get() = 750

    override val maxGenesisTorpedoes: Int
        get() = 5

    override val maxHolds: Int
        get() = 75

    override val maxMineDisrupters: Int
        get() = 10

    override val maxShields: Int
        get() = 400

    override val offensiveShipOdds: Int
        get() = 10

    override val psychicProbe: Boolean
        get() = false

    override val shipValue: String
        get() = "Low"

    override val transportRange: Int
        get() = 5

    override val transwarpDrive: Boolean
        get() = false

}
