package nl.hilgenbos.tournamentfx.controller

import javafx.scene.text.Text
import nl.hilgenbos.tournamentfx.view.MarkdownView
import tornadofx.*

class WorkspaceController : Controller() {

    val markdownView: MarkdownView by inject()
    val textArea = markdownView.root

    /** set text in TextArea */
    fun setText(text: String) {
        textArea.text = text
    }

}