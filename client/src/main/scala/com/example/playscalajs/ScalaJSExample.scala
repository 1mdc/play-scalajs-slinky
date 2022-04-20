package com.example.playscalajs

import com.example.playscalajs.bootstrap.laylouts.Container
import org.scalajs.dom.document
import slinky.core.StatelessComponent
import slinky.core.annotations.react
import slinky.web.ReactDOM
import slinky.web.html._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("bootstrap/scss/bootstrap.scss", JSImport.Namespace)
object BootstrapCss extends js.Object

object ScalaJSExample {

  private val bootstrapCss = BootstrapCss

  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      Container(HelloName("Hoang")),
      document.getElementById("root")
    )
  }
}


@react class HelloName extends StatelessComponent {
  case class Props(name: String)

  def render = {
    h1(s"Hello ${props.name}")
  }
}