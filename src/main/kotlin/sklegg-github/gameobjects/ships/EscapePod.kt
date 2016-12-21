package `sklegg-github`.gameobjects.ships

import `sklegg-github`.gameobjects.AbstractShip

/**
 * Created by scott on 12/20/16.
 * Escape pod ship
 */
class EscapePod : AbstractShip() {
    override val shipType: String
        get() { return "Escape Pod" }

    override val purchaseCost: Int
        get() { return 0 }





}