package nl.hilgenbos.tournamentfx.view

import javafx.beans.property.SimpleIntegerProperty
import javafx.geometry.Pos
import nl.hilgenbos.tournamentfx.app.Styles
import nl.hilgenbos.tournamentfx.controller.TournamentController
import tornadofx.*

class TournamentView : View("Tournament view") {

    val tournamentController : TournamentController by inject()


    override val root = vbox {
        alignment = Pos.CENTER
        spacing = 10.0
        setPrefSize(500.0, 400.0)
        label("Tournament") {
            addClass(Styles.heading)
        }
        button (){
            this.text = "Click Me!"
            action {

            }
        }
    }



}