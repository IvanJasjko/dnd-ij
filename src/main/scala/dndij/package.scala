package object dndij {

  case class Npc(race: Race, weapon: Weapon, element: Element)
  case class Race(name: String, health: Int)
  case class Weapon(wepType: String, dmg: Int)
  case class Element(name: String, status_effect: String, extra_dmg: Int)
}
