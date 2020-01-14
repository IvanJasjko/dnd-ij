package dndij

import GamePlay._

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    val player = Character(Human, SniperRifle, Human.health)

    val oppRace = List(Orc, Goblin, HobGoblin)(Random.nextInt(2))
    val oppWeapon = List(Axe, ShortSword, Scimitar)(Random.nextInt(2))

    val opponent = Character(oppRace, oppWeapon, oppRace.health)
    engage(player, opponent)
  }
}
