package dndij

trait Enhancement {
  def fire

  def earth

  def thunder

  def ice
}

class Weapon(weaponType: String, element: String = "none") {

  val name: String = element match {
    case "" => weaponType
    case _ => s"${weaponType.capitalize} of ${element.capitalize}"
  }

  val (hit, baseDamage, bonusDamage) = weaponType match {
    case "Axe" => (5, NDd(1, 12), 0)
    case "Scimitar" => (4, NDd(1, 6), 2)
    case "Short sword" => (5, NDd(1, 6), 3)
    case "Sword" => (5, NDd(1, 6), 4)
    case "Sniper rifle" => (15, NDd(2, 12), 7)
    case _ => throw new IllegalArgumentException(weaponType)
  }

  val enhancement: String = element
}
