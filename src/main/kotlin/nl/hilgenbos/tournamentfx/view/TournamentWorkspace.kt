package nl.hilgenbos.tournamentfx.view

import javafx.application.Platform
import javafx.scene.control.TabPane
import tornadofx.*

class TournamentWorkspace : Workspace("Tournament Workspace", NavigationMode.Tabs) {

    init {

        createMenu()

        dock<TournamentView>()
        dock<RefereeView>()
        dock<FencerView>()

        tabContainer.tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
    }

    private fun createMenu() {
        menubar {
            menu("File") {
                item("New") {

                }
                separator()
                item("Exit").action {
                    log.info("Leaving workspace")
                    Platform.exit()
                }
                separator()
                item("Login")
                item("Logout")
            }
            menu("Window") {
                item("Close all").action {

                }
                separator()
            }
            menu("Help") {
                item("About...").action {
                    openInternalWindow<MarkdownView>(closeButton = true, modal = true, )
                }
            }


        }
    }
}

