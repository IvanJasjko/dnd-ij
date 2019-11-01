package dndij

import Combat._

object Main {

  def main(args: Array[String]): Unit = {
    val sword = new Weapon("Sniper rifle")
    println(processAttack(sword))

  }
}
