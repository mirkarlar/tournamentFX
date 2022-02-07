package nl.hilgenbos.tournamentfx.app

import javafx.stage.Stage
import nl.hilgenbos.tournamentfx.view.TournamentWorkspace
import tornadofx.*

class MyApp : App(TournamentWorkspace::class, Styles::class) {

    override fun start(stage: Stage) {
        with(stage) {
            width = 1200.0
            height = 600.0

        }
        super.start(stage)
    }
}