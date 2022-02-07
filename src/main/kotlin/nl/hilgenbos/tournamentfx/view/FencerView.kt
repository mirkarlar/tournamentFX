package nl.hilgenbos.tournamentfx.view

import javafx.geometry.Pos
import nl.hilgenbos.tournamentfx.controller.FencerController
import nl.hilgenbos.tournamentfx.model.Fencer
import nl.hilgenbos.tournamentfx.model.FencerModel
import tornadofx.*

class FencerView : View("Fencer View") {

    private val model: FencerModel by inject()
    private val controller: FencerController by inject()

    override val root = borderpane {
        center = vbox {
            alignment = Pos.CENTER
            paddingBottom = 20.0
            paddingLeft = 20.0
            paddingRight = 20.0

            form {
                fieldset {
                    tableview(controller.listOfFencers) {
                        column("First Name", Fencer::firstName)
                        column("Last Name", Fencer::lastName).makeEditable()
                        column("weapon", Fencer::weapon).makeEditable()
                        bindSelected(model)
                    }
                }
                fieldset {
                    field("First Name") {
                        maxWidth = 220.0
                        textfield(model.firstName) {
                            this.required()
                            validator {
                                when {
                                    it.isNullOrEmpty() -> error("Field cannot be empty")
                                    it.length < 3 -> error("Too short")
                                    else -> null
                                }
                            }
                        }
                    }
                    field("Last Name") {
                        maxWidth = 220.0
                        textfield(model.lastName) {
                            this.required()
                            validator {
                                when {
                                    it.isNullOrEmpty() -> error("Field cannot be empty")
                                    it.length < 3 -> error("Too short")
                                    else -> null
                                }
                            }
                        }
                    }
                    field("Weapon") {
                        maxWidth = 220.0
                        combobox(model.weapon, controller.weapons) {
                            this.required()
                        }
                    }
                    button("Add") {
                        enableWhen(model.valid)
                        action {
                            model.commit()
                            var fencer: Fencer = Fencer(model.firstName.value, model.lastName.value, model.weapon.value)
                            controller.addFencer(fencer)
                            model.rollback() // reset form
                        }
                    }
                }
            }

            hbox(10.0) {

                button("Delete") {

//                action {
//                    val selectedItem = mTableView.tableView.selectedItem
//                    when (selectedItem) {
//                        null -> controller.delete(selectedItem!!)
//
//                        else -> {
//                            val diff = totalExpensesProperty.value.toDouble() - selectedItem.item.itemPrice.toDouble()
//                            totalExpensesProperty.value = diff
//
//                            controller.delete(selectedItem)
//                            updateTotalExpenses()
//                        }
//                    }
//                }
                }
                button("Reset") {
                    enableWhen(model.valid)
                    action {
                        model.commit {
                            model.rollback() // reset form
                        }
                    }
                }
            }
        }

    }
}
