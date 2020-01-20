package dndij

import dndij.Combat.takeAttack

import scala.annotation.tailrec
import scala.io.StdIn

object GamePlay {

  type Outcome = (Character, Character)

  def engage(player: Character, npc: Character): Character = {
    println(s"\n${player.race.getName} with ${player.weapon.getName} VS ${npc.race.getName} with ${npc.weapon.getName}")
    val winner = executeTurns(player, npc)
    println(s"\n${winner.race.getName} was victorious with ${winner.health} health left and ${winner.status} status!")
    player
  }

  @tailrec
  private def executeTurns(player: Character, npc: Character): Character = {
    if (player.health <= 0.0)
      npc
    else if (npc.health <= 0.0)
      player
    else {
      println(s"\nYour health (${player.health})\nEnemy health (${npc.health})")
      val (updated_player, updated_npc) = playTurn(player, npc)
      executeTurns(updated_player, updated_npc)
    }
  }

  private def playTurn(player: Character, npc: Character): Outcome = {
    val turnOptions = List("attack", "drink", "inventory")
    chooseOption(turnOptions) match {
      case "attack" => fight(player, npc)
      case _ => (player, npc)
    }

    //TODO add user input
  }

  private def fight(player: Character, npc: Character): Outcome = {
    val npcAttack = npc.weapon.processAttack()
    val playerAttack = player.weapon.processAttack()
    val newPlayer = takeAttack(player, npcAttack)
    val newNpc = takeAttack(npc, playerAttack)
    if (playerAttack.damage == 0.0)
      println(s"\n${player.race.getName} misses attack against ${npc.race.getName}!")
    else
      println(s"\n${player.race.getName} hits ${npc.race.getName}!")
    if (npcAttack.damage == 0.0)
      println(s"${npc.race.getName} misses attack against ${player.race.getName}")
    else
      println(s"${npc.race.getName} hits ${player.race.getName} back!")
    (newPlayer, newNpc)
  }

  @tailrec
  private def chooseOption(options: List[String]): String = {
    println("\nChoose your action:")
    options.zipWithIndex.foreach(x => println(s"${x._2 + 1}. ${x._1.capitalize}"))
    StdIn.readLine().toInt match {
      case 1 => options.head
      case 2 => options(1)
      case 3 => options(2)
      case _ => chooseOption(options)
    }
  }
}
