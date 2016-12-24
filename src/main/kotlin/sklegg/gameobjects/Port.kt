package sklegg.gameobjects

/**
 * Created by scott on 12/22/16.
 * Lives in a sector and trades resources
 */

class Port (portName: String, portClass: Int){
    var portName: String = ""
    var portClass: Int = 0
    var tradingLog: String = ""



 /* (BBS) - buying fuel ore, buying organics, selling equipment
    (BSB) - buying fuel ore, selling organics, buying equipment
    (SBB) - selling fuel ore, buying organics, buying equipment
    (SSB) - selling fuel ore, selling organics, buying equipment
    (SBS) - selling fuel ore, buying organics, selling equipment
    (BSS) - buying fuel ore, selling organics, selling equipment
    (SSS) - selling fuel ore, selling organics, selling equipment
    (BBB) - buying fuel ore, buying organics, buying equipment */

    fun sellsFuel(): Boolean {
        return portClass == 3 || portClass == 4 || portClass == 5 || portClass == 7
    }

    fun buysFuel(): Boolean {
        return !sellsFuel()
    }

    fun sellsOrganics(): Boolean {
        return portClass == 2 || portClass == 4 || portClass == 6 || portClass == 7
    }

    fun buysOrganics(): Boolean {
        return !sellsOrganics()
    }

    fun sellsEquipment(): Boolean {
        return portClass == 1 || portClass == 5 || portClass == 6 || portClass == 7
    }

    fun buysEquipment(): Boolean {
        return !sellsEquipment()
    }

}