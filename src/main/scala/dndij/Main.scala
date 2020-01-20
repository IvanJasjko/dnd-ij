package dndij

import GamePlay._
import Misc.produceOpponent

object Main {

  def main(args: Array[String]): Unit = {
    val player = Character(Human, Sword, Human.health)
      val opponent = produceOpponent()
      engage(player, opponent)
  }
}
