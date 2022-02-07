package nl.hilgenbos.tournamentfx.view

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import nl.hilgenbos.tournamentfx.model.UserModel
import tornadofx.*

class WelcomScreen : View("Welcome") {


    val userModel: UserModel by inject()


    override val root = vbox(10) {
        setPrefSize(500.0, 400.0)
        label("Welcome to wonderland") {
            style {
                fontSize = 19.px
                padding = box(10.px)
                textFill = Color.GREEN
                fontWeight = FontWeight.EXTRA_BOLD
                borderRadius = multi(box(8.px))
                backgroundColor += c("white", 0.8)
            }
        }
        label(userModel.name)


    }
}
