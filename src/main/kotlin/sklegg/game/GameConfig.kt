package sklegg.game

/**
 * Created by scott on 12/23/16.
 * Holds configuration options for current game
 */
class GameConfig {
    /* TODO: read from game.properties */
    var turnsPerGame: Int = 1000
    var numSectors: Int = 100
    var initialCredits: Int = 50000
    var initialFighters: Int = 1000
    var initialHolds: Int = 50

}