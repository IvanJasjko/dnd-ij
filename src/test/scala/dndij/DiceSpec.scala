package dndij

import org.scalatest._
import dndij.Dice.roll

class DiceSpec extends FunSuite with Matchers {

  test("Dice should be rolled the specified amount of times") {
    roll(1, 1) shouldBe 1
    roll(3, 1) shouldBe 3
    roll(99, 1) shouldBe 99
  }

  test("Dice should sum the amounts correctly") {
    assert(3 to 18 contains roll(3, 6))
  }

}
