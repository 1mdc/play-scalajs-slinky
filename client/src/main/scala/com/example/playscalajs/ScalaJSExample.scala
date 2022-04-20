package com.example.playscalajs

import com.example.playscalajs.bootstrap.components._
import com.example.playscalajs.bootstrap.laylouts._
import org.scalajs.dom.document
import slinky.web.ReactDOM

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("bootstrap/scss/bootstrap.scss", JSImport.Namespace)
object BootstrapCss extends js.Object

object ScalaJSExample {

  private val bootstrapCss = BootstrapCss

  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      Container(Button("Click Me")),
      document.getElementById("root")
    )
  }
}
