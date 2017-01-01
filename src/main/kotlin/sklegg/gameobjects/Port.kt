package sklegg.gameobjects

import com.github.salomonbrys.kotson.toJson
import com.google.gson.JsonObject

/**
 * Created by scott on 12/22/16.
 * Lives in a sector and trades resources
 */

class Port (var sectorNumber: Int, var portName: String, var portClass: Int){
    var tradingLog: String = ""

    val maxFuel: Int = 880
    val maxOrganics: Int = 1630
    val maxEquipment: Int = 1620

    var currentFuel = maxFuel
    var currentOrganics = maxOrganics
    var currentEquipment = maxEquipment



    fun toJson(): JsonObject {
        val result = JsonObject()
        result.add("type","PORT".toJson())
        result.add("id", sectorNumber.toJson())
        result.add("portName",  portName.toJson())
        result.add("portClass", portClass.toJson())
        result.add("sellsFuel", this.sellsFuel().toJson())
        result.add("buysFuel", this.buysFuel().toJson())
        result.add("sellsOrganics", this.sellsOrganics().toJson())
        result.add("buysOrganics", this.buysOrganics().toJson())
        result.add("sellsEquipment", this.sellsEquipment().toJson())
        result.add("buysEquipment", this.buysEquipment().toJson())
        return result
    }

    fun serialize() : String {
        return toJson().toString()
    }

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