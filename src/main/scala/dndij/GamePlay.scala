package dndij

import dndij.Combat.takeAttack
import scala.annotation.tailrec

object GamePlay {

  def engage(player: Character, npc: Character): Unit = {
    println(s"${player.race.getName} with ${player.weapon.getName} VS ${npc.race.getName} with ${npc.weapon.getName}")
    val winner = executeTurns(player, npc)
    println(s"\n${winner.race.getName} was victorious with ${winner.health} health left and ${winner.status} status!")
  }

  @tailrec
  private def executeTurns(player: Character, npc: Character): Character = {
    if (player.health <= 0.0)
      npc
    else if (npc.health <= 0.0)
      player
    else {
      val (updated_player, updated_npc) = playTurn(player, npc)
      executeTurns(updated_player, updated_npc)
    }
  }

  private def playTurn(player: Character, npc: Character): (Character, Character) = {
    //TODO add user input
    val npcAttack = npc.weapon.processAttack()
    val playerAttack = player.weapon.processAttack()

    val newPlayer = takeAttack(player, npcAttack)
    val newNpc = takeAttack(npc, playerAttack)

    println(s"\n${player.race.getName} hits ${npc.race.getName}!")
    println(s"${npc.race.getName} hits ${player.race.getName} back!")

    (newPlayer, newNpc)
  }


}
