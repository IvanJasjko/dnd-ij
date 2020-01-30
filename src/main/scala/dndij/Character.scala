package dndij

case class Character(race: Race,
                      weapon: Weapon,
                      health: Double,
                      status: String = "none")