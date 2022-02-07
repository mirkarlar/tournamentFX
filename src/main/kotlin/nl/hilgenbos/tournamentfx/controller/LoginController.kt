package nl.hilgenbos.tournamentfx.controller

import javafx.beans.property.SimpleStringProperty
import nl.hilgenbos.tournamentfx.model.UserModel
import nl.hilgenbos.tournamentfx.view.LoginScreen
import nl.hilgenbos.tournamentfx.view.WelcomScreen
import tornadofx.*

class LoginController : Controller() {


    val statusProperty = SimpleStringProperty("")
    var loginStatus: String by statusProperty

    val api: Rest by inject()
    val user : UserModel by inject()

    init {
        api.baseURI = "https://api.github.com"
    }

    fun login(username: String, password: String) {
        runLater {
            loginStatus = ""
        }
        api.setBasicAuth(username, password)
        val response = api.get("users/mirkarlar")
        val json = response.one()
        runLater {
            if (response.ok()) {
                user.item = json.toModel()
                find(LoginScreen::class).replaceWith(WelcomScreen::class, sizeToScene = true, centerOnScreen = true)
                println("login successful")
            } else {
                loginStatus = json.string("message") ?: "Login failed!"
                println("login failed")
            }
        }

    }


}