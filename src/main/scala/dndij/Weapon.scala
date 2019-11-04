package dndij

trait Enhancement {
  def fire

  def earth

  def thunder

  def ice
}

class Weapon(weaponType: String, element: String = "none") extends Enchanted {

  val name: String = element match {
    case "" => weaponType
    case _ => s"${weaponType.capitalize} of ${element.capitalize}"
  }

  val (hit, baseDamage, bonusDamage) = weaponType match {
    case "Axe" => (5, NDs(1, 12), 0)
    case "Scimitar" => (4, NDs(1, 6), 2)
    case "Short sword" => (5, NDs(1, 6), 3)
    case "Sword" => (5, NDs(1, 6), 4)
    case "Sniper rifle" => (20, NDs(2, 12), 7)
    case _ => throw new IllegalArgumentException(weaponType)
  }

  val enhancement: String = element
}
