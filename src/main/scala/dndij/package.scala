package object dndij {

  // Game
  case class NDd(n: Int, d: Int)
  // Combat
  case class Attack(damage: Int, status: String, miss: Double)
  // Characters
  case class Race(name: String, health: Int, Armor: Int, weapon: Weapon)

}
