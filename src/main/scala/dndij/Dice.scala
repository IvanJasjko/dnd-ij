package dndij

import scala.util.Random

object Dice {
  def roll(nd: NDd): Int = {
    val rolls = for (_ <- 0 until nd.n) yield {
      Random.nextInt(nd.d) + 1
    }
    rolls.toList.sum
  }
}
