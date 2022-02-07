package nl.hilgenbos.tournamentfx.controller

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import nl.hilgenbos.tournamentfx.model.Fencer
import tornadofx.*

class FencerController : Controller() {

  public val listOfFencers: ObservableList<Fencer> =
      mutableListOf (Fencer("Wim-Jan", "Hilgenbos", "Sabre"),
          Fencer("Qiang", "Hilgenbos", "Foil"),
          Fencer("Jasper", "...", "Foil")
      ).asObservable()

    val weapons = FXCollections.observableArrayList("Foil",
        "Epee","Sabre")

    fun addFencer(fencer: Fencer) {
        listOfFencers.add(fencer)
    }

    fun update (fencer: Fencer) {
        // not sure what to do yet
    }

    fun delete(fencer: Fencer) {
        listOfFencers.remove(fencer)
    }

}