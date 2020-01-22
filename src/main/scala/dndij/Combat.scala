package dndij

import Utils.prob

case class Attack(damage: Double, status: String)

object Combat {

  def getElementalModifier(weapon: Weapon, race: Race): Double = {
    val weaponElement = weapon.enhancement
    val armorElement = race.enhancement

    if (weaponElement == "none" || armorElement == "none")
      return 1.0

    val counterMap = Map(
      "ice" -> "thunder",
      "thunder" -> "earth",
      "earth" -> "fire",
      "fire" -> "ice"
    )
    if (weaponElement == counterMap(armorElement))
      1.5
    else if (weaponElement == armorElement)
      0.5
    else
      1.0
  }

  def takeAttack(character: Character, attack: Attack): Character = {
    character.copy(
      health = character.health - attack.damage * character.race.armor * 0.1,
      status = applyStatus(attack.status))
  }

  private def applyStatus(status: String): String = {
    if (prob(35) && status != "none")
      status
    else
      "healthy"
  }
}
