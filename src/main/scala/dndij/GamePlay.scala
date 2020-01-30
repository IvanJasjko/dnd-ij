package dndij

import Misc.produceOpponent
import dndij.Combat.takeAttack

import scala.annotation.tailrec
import scala.io.StdIn

object GamePlay {

  case class Outcome(player: Character, npc: Character)

  @tailrec
  def runGame(player: Character, counter: Int = 0): Unit = {
    val updatedPlayer = engage(player, produceOpponent()).player
    if (updatedPlayer.health <= 0)
      println(s"${player.race.getName} has died after defeating $counter enemies")
    else {
      runGame(updatedPlayer, counter + 1)
    }
  }

  def engage(player: Character, npc: Character): Outcome = {
    println(s"\n${player.race.getName} with ${player.weapon.getName} VS ${npc.race.getName} with ${npc.weapon.getName}")
    val fightOutcome = executeTurns(player, npc)
    val winner = Seq(fightOutcome.player, fightOutcome.npc).maxBy(_.health)
    println(s"\n${winner.race.getName} was victorious with ${winner.health} health left")
    fightOutcome
  }

  @tailrec
  private def executeTurns(player: Character, npc: Character): Outcome = {
    if (player.health <= 0.0 || npc.health <= 0)
      Outcome(player.copy(status = "none"), npc)
    else {
      println(s"\nYour health (${player.health})\nEnemy health (${npc.health})")
      println(player.status)
      val Outcome(updated_player, updated_npc) = playTurn(player, npc)
      executeTurns(updated_player, updated_npc)
    }
  }

  private def playTurn(player: Character, npc: Character): Outcome = {
    val turnOptions = List("attack", "drink", "inventory")
    chooseOption(turnOptions) match {
      case "attack" =>
        fight(player, npc)
      case _ => Outcome(player, npc)
    }
  }

  private def fight(player: Character, npc: Character): Outcome = {
    //TODO Add status processing
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
    Outcome(newPlayer, newNpc)
  }

  @tailrec
  private def chooseOption(options: List[String]): String = {
    println("\nChoose your action:")
    options.zipWithIndex.foreach(x => print(s"${x._2 + 1}. ${x._1.capitalize} "))
    val choice = StdIn.readLine()
    val inputOptions = for (i <- 1 until 10) yield i.toString
    if (!inputOptions.contains(choice))
      chooseOption(options)
    else
      choice.toInt match {
        case 1 => options.head
        case 2 => options(1)
        case 3 => options(2)
        case _ => chooseOption(options)
      }
  }
}
