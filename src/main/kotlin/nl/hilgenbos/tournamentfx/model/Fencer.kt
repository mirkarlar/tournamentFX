package nl.hilgenbos.tournamentfx.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Fencer (fname: String, lName: String, weapontype : String) : JsonModel {

    val firstNameProperty = SimpleStringProperty(fname)
    var firstName by firstNameProperty

    val lastNameProperty = SimpleStringProperty(lName)
    var lastName by lastNameProperty

    val weaponProperty = SimpleStringProperty(weapontype)
    var weapon by weaponProperty




    override fun updateModel(json: JsonObject) {
        with(json) {
            firstName = string("firstName")
            lastName = string("lastName")
            weapon = string("weapon")
        }
        super.updateModel(json)
    }


}