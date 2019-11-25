package dndij

import scala.annotation.tailrec

object Combat {

  def engage(player: Character, npc: Character): Unit = {
    println(s"${player.race.getName} with ${player.weapon.getName} VS ${npc.race.getName} with ${npc.weapon.getName}")
    makeTurns(player, npc, HpSummary(player.race.health, npc.race.health, npc))
  }

  def getElementalModifier(weapon: Weapon, race: Race): Double = {
    val weaponElement = weapon.enhancement
    val armorElement = race.enhancement

    if (weaponElement == "none" || armorElement == "none")
      return 1.0

    val counterMap = Map(
      "ice" -> "thunder",
      "thunder" -> "earth",
      "earth" -> "fire",
      "fire" -> "ice"
    )
    if (weaponElement == counterMap(armorElement))
      1.5
    else if (weaponElement == armorElement)
      0.5
    else
      1.0
  }

  //TODO Failing recursion
  @tailrec
  private def makeTurns(player: Character, npc: Character, summary: HpSummary): Character = {
    if (summary.playerHealth == 0)
      npc
    else if (summary.npcHealth == 0)
      player
    else {
      if (summary.attacker == player)
        makeTurns(player, npc, playTurn(player, npc))
      else
        makeTurns(player, npc, playTurn(npc, player))
    }
  }

  private def playTurn(player: Character, npc: Character): HpSummary = {
    //TODO Add user input etc.
    HpSummary(player.race.health - 1, npc.race.health - 3, player)
  }

}
