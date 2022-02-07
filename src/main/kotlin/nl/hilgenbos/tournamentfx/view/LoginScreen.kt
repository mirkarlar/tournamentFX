package nl.hilgenbos.tournamentfx.view

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Orientation
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import nl.hilgenbos.tournamentfx.controller.LoginController
import tornadofx.*

class LoginScreen : View("My View") {

    val loginController: LoginController by inject()
    val model = ViewModel()
    val username = model.bind { SimpleStringProperty() }
    val password = model.bind { SimpleStringProperty() }

    override val root = form {
        setPrefSize(500.0, 400.0)

        fieldset(labelPosition = Orientation.VERTICAL) {
            fieldset("Username") {
                textfield(username).required()
            }
            fieldset("Password") {
                passwordfield(password).required()
            }
            button("Log in") {
                enableWhen(model.valid)
                isDefaultButton = true
                useMaxWidth = true
                action {
                    runAsyncWithProgress {
                        loginController.login(username.value, password.value)
                    }
                }
            }
        }

        label(loginController.statusProperty) {
            style {
                paddingTop = 15
                textFill = Color.RED
                fontWeight = FontWeight.BOLD
            }
        }

    }
}
