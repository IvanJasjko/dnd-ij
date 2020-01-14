package dndij

import scala.util.Random

case class NDs(n: Int, d: Int)

object Utils {
  def roll(nd: NDs): Int = {
    val rolls = for (_ <- 0 until nd.n) yield {
      Random.nextInt(nd.d) + 1
    }
    rolls.toList.sum
  }

  def prob(percentage: Int): Boolean = {
    Random.nextInt(100) <= percentage
  }
}
