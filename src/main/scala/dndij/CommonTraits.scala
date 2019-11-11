package dndij

import scala.util.Random

trait Enchanted {

  private def genElement(): String = {
    val elements = Seq("Ice", "Fire", "Thunder", "Earth")
    elements(Random.nextInt(elements.length))
  }

  def enhance(): String = {
    val element = genElement()
    val chance = Random.nextInt(100)
    if (chance <= 10)
      element
    else
      "none"
  }
  val enhancement: String = enhance()
}

trait Name {
  def getName: String
}

