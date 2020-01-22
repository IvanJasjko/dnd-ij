package dndij

import scala.util.Random
import Utils.prob

trait Enchanted {

  private def genElement(): String = {
    val elements = Seq("ice", "fire", "thunder", "earth")
    elements(Random.nextInt(elements.length))
  }

  def enhance(): String = {
    val element = genElement()
    if (prob(50))
      element
    else
      "none"
  }
  val enhancement: String = enhance()

}

trait Name {
  def getName: String
}

