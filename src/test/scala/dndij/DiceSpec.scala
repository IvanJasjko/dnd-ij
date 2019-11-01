package dndij

import org.scalatest._
import dndij.Dice.roll

class DiceSpec extends FunSuite with Matchers {

  test("Dice should be rolled the specified amount of times") {
    roll(NDd(1, 1)) shouldBe 1
    roll(NDd(3, 1)) shouldBe 3
    roll(NDd(99, 1)) shouldBe 99
  }

  test("Dice should sum the amounts correctly") {
    assert(3 to 18 contains roll(NDd(3, 6)))
  }

}
