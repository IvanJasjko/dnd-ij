package dndij

import Utils._

object Combat {

  def processAttack(weapon: Weapon): Attack = {
    val missChance = 20
    if (prob(missChance - weapon.hit)) {
      val attackDamage = roll(weapon.baseDamage) + weapon.bonusDamage
      Attack(attackDamage, weapon.enhancement)
    } else {
      val attackDamage = 0 // Miss
      Attack(attackDamage, weapon.enhancement)
    }
  }

}
