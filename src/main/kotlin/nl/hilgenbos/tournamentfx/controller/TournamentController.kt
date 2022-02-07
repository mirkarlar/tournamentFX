package nl.hilgenbos.tournamentfx.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class TournamentController : Controller() {
    var labelText  = SimpleStringProperty()
    var aboutText = SimpleStringProperty()

    init {

    }
    private val nameslist : List<String> = listOf(
        "aap",
        "noot",
        "mies",
        "wim",
        "zus",
        "jet"
    )

     fun getRandomName () {
        val randomInteger : Int = (1..(nameslist.size-1)).shuffled().first()
        print ("Random $randomInteger")
        labelText.value = nameslist[randomInteger]
    }

    fun readAboutText() {
        val resourceAsStream = javaClass.classLoader.getResourceAsStream("config.properties")
    }

}