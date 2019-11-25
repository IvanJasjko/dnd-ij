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
    if (prob(missChance - hit)) {
      val attackDamage = roll(baseDamage) + bonusDamage
      Attack(attackDamage, enhancement)
    } else {
      val attackDamage = 0 // Miss
      Attack(attackDamage, enhancement)
    }
  }

  def getName: String = {
    enhancement match {
      case "none" => name.capitalize
      case _ => name.capitalize + " of " + enhancement.capitalize
    }
  }

}

case class Axe(desc: String) extends Weapon {
  val name = "axe"
  val (hit, baseDamage, bonusDamage) = (5, NDs(1, 12), 0)
}

case class Sword(desc: String) extends Weapon {
  val name = "sword"
  val (hit, baseDamage, bonusDamage) = (5, NDs(1, 6), 4)
}

case class Scimitar(desc: String) extends Weapon {
  val name = "scimitar"
  val (hit, baseDamage, bonusDamage) = (4, NDs(1, 6), 2)
}

case class ShortSword(desc: String) extends Weapon {
  val name = "short sword"
  val (hit, baseDamage, bonusDamage) = (5, NDs(1, 6), 3)
}

case class SniperRifle(desc: String) extends Weapon {
  val name = "sniper rifle"
  val (hit, baseDamage, bonusDamage) = (20, NDs(2, 12), 7)
}
