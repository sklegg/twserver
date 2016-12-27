package sklegg.gameobjects

import java.util.*

/**
 * Created by scott on 12/22/16.
 * Represents a human player and their stats
 */
class Player (var playerName: String = "", var alignment: Int = 0){
    var sectorsVisited: Array<Int> = emptyArray()

    var lastLogin: Date? = null
    var numTurns: Int = 0
    var experience: Int = 0
}