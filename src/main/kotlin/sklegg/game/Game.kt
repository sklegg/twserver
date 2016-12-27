package sklegg.game

import sklegg.gameobjects.Player
import sklegg.gameobjects.UniverseMap

/**
 * Created by scott on 12/26/16.
 * Holds global state of the game
 */
class Game(val map: UniverseMap, val players: Array<Player>) {
    /* TODO: figure out persistence. JSON file store or db makes sense */
}