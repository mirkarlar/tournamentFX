package nl.hilgenbos.tournamentfx.model

import tornadofx.*

class FencerModel : ItemViewModel<Fencer>() {

    val firstName = bind(Fencer::firstNameProperty)
    val lastName = bind(Fencer::lastNameProperty)
    val weapon = bind(Fencer::weaponProperty)
}