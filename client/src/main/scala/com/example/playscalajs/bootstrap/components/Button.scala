package com.example.playscalajs.bootstrap.components

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.web.html.{`type`, button, className}

@react object Button {
  case class Props(text: String)

  val component = FunctionalComponent[Props] { props =>
    button(`type` := "button", className := "btn btn-primary")(props.text)
  }
}
