package nl.hilgenbos.tournamentfx.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import nl.hilgenbos.tournamentfx.view.MarkdownView
import tornadofx.*

class TextModel : ViewModel() {
    val textAreaView: MarkdownView by inject()
    val textArea = textAreaView.root

    val textProperty = SimpleStringProperty("")
    val charCounterProperty = SimpleIntegerProperty(0)

    val text = bind { textProperty }
    val charCounter = bind { charCounterProperty }

    init {
        // bind bidirectional (textProperty <=> textArea)
        textProperty.bindBidirectional(textArea.textProperty())

        // when update text, then update charCounter
        textProperty.addListener({
            /*observableValue*/_, /*oldValue*/_, newValue ->
            charCounterProperty.set(newValue.length)
        })
    }

    fun reset() {
        textProperty.set("")
    }

}
