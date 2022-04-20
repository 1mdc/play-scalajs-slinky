package com.example.playscalajs.bootstrap.laylouts

import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html._

@react object Container {
  case class Props(children: ReactElement*)

  val component = FunctionalComponent[Props] { props =>
    div(className := "container")(props.children)
  }
}
