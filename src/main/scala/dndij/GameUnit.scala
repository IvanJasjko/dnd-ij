package dndij

trait Playable {

}

trait Race {
  val name: String
  val health: Int
  val armor: Int
}

class GameUnit(weapon: Weapon) extends Playable //???
  with Enchanted
  with Race {

  val armor = 1
  val health = 1
  val name = "2"

  println(weapon)

}
