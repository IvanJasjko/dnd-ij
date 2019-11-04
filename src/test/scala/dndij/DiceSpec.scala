package dndij

import org.scalatest._
import dndij.Utils.roll

class DiceSpec extends FunSuite with Matchers {

  test("Utils should be rolled the specified amount of times") {
    roll(NDs(1, 1)) shouldBe 1
    roll(NDs(3, 1)) shouldBe 3
    roll(NDs(99, 1)) shouldBe 99
  }

  test("Utils should sum the amounts correctly") {
    assert(3 to 18 contains roll(NDs(3, 6)))
  }

}
