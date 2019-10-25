package dndij

import scala.util.Random

object Dice {
  //Roll nDd
  def roll(n: Int, d: Int): Int = {
    val rolls = for (_ <- 0 until n) yield {
      Random.nextInt(d) + 1
    }
    rolls.toList.sum
  }
}
