package dndij

import GamePlay._
object Main {

  def main(args: Array[String]): Unit = {
    val player = Character(Human, SniperRifle, Human.health)
    runGame(player)
  }
}
