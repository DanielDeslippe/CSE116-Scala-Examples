package gui

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.{Button, TextField}
import scalafx.scene.layout.VBox


object SampleGUI extends JFXApp {

  val inputDisplay: TextField = new TextField {
    style = "-fx-font: 18 ariel;"
  }

  val outputDisplay: TextField = new TextField {
    editable = false
    style = "-fx-font: 18 ariel;"
  }

  def buttonPressed(): Unit = {
    println(inputDisplay.text.value)
    val fahrenheit: Double = inputDisplay.text.value.toDouble
    val celsius = (fahrenheit - 32.0) * 5.0 / 9.0
    outputDisplay.text = f"$celsius%1.2f"
  }

  val button: Button = new Button {
    minWidth = 100
    minHeight = 100
    style = "-fx-font: 28 ariel;"
    text = "F to C"
    onAction = event => buttonPressed()
  }

  this.stage = new PrimaryStage {
    title = "GUI Example"
    scene = new Scene() {
      content = List(
        new VBox() {
          children = List(inputDisplay, button, outputDisplay)
        }
      )
    }
  }

}
