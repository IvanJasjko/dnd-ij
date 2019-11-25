package dndij

import scala.util.Random

trait Enchanted {

  private def genElement(): String = {
    val elements = Seq("ice", "fire", "thunder", "earth")
    elements(Random.nextInt(elements.length))
  }

  def enhance(): String = {
    val element = genElement()
    val chance = Random.nextInt(100)
    if (chance <= 50)
      element
    else
      "none"
  }
  val enhancement: String = enhance()
}

trait Name {
  def getName: String
}

