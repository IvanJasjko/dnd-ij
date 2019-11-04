package dndij

import Combat._

object Main {

  def main(args: Array[String]): Unit = {
    val sword = new Weapon("Axe")
    println(processAttack(sword))

  }
}
