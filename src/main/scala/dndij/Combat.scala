package dndij

import Dice.roll

object Combat {
  def processAttack(weapon: Weapon): Attack = {
    Attack(
      roll(weapon.baseDamage) + weapon.bonusDamage,
      weapon.enhancement,
      (15 - weapon.hit) / 100.0
    )
  }
}
