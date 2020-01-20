package dndij

import dndij.Utils.{prob, roll}

trait Cursed {

}

trait Weapon extends Enchanted with Name with Cursed {

  val name: String
  val baseDamage: NDs
  val hit: Int
  val bonusDamage: Int

  def processAttack(): Attack = {
    val missChance = 20
    if (prob(100 - missChance + hit)) {
      Attack(roll(baseDamage) + bonusDamage, enhancement)
    } else {
      Attack(0, enhancement)
    }
  }

  def getName: String = {
    enhancement match {
      case "none" => name.capitalize
      case _ => name.capitalize + " of " + enhancement.capitalize
    }
  }
}

object Axe extends Weapon {
  val name = "axe"
  val (hit, baseDamage, bonusDamage) = (5, NDs(1, 12), 0)
}

object Sword extends Weapon {
  val name = "sword"
  val (hit, baseDamage, bonusDamage) = (4, NDs(2, 6), 7)
}

object Scimitar extends Weapon {
  val name = "scimitar"
  val (hit, baseDamage, bonusDamage) = (4, NDs(1, 6), 2)
}

object ShortSword extends Weapon {
  val name = "short sword"
  val (hit, baseDamage, bonusDamage) = (5, NDs(1, 6), 3)
}

object SniperRifle extends Weapon {
  val name = "sniper rifle"
  val (hit, baseDamage, bonusDamage) = (20, NDs(2, 12), 7)
}
