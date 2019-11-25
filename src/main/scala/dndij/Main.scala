package dndij

import Combat._

object Main {

  def main(args: Array[String]): Unit = {
    val player = Character(Human("good"), SniperRifle("AWP"))
    val opponent = Character(Orc("evil"), Axe("rugged"))
    engage(player, opponent)
  }
}
