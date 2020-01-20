package dndij

import scala.util.Random

object Misc {
  def produceOpponent(): Character = {
    val oppRace = List(Orc, Goblin, HobGoblin)(Random.nextInt(2))
    val oppWeapon = List(Axe, ShortSword, Scimitar)(Random.nextInt(2))
    Character(oppRace, oppWeapon, oppRace.health)
  }
}
