package dndij

import GamePlay._

object Main {

  def main(args: Array[String]): Unit = {
    val player = Character(Human, SniperRifle, Human.health)
    val opponent = Character(Orc, Axe, Orc.health)
    engage(player, opponent)
  }
}
