package com.example.playscalajs

import com.example.playscalajs.shared.SharedMessages
import org.scalajs.dom
import org.scalajs.dom.document
import slinky.web.ReactDOM
import slinky.web.html._

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks

    ReactDOM.render(
      h1("Hello, world!"),
      document.getElementById("root")
    )
  }
}
