package nl.hilgenbos.tournamentfx.view

import javafx.scene.text.Font
import nl.hilgenbos.tournamentfx.controller.WorkspaceController
import nl.hilgenbos.tournamentfx.util.Constant
import tornadofx.*

class MarkdownView : View("About") {

    val workspaceController : WorkspaceController by inject()

    override val root = textarea {
        useMaxWidth = true
        font = Font.font(Constant.TEXTAREA_FONT_SIZE)
        isWrapText = true

    }
}
