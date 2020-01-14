package dndij

trait Playable {

}

case class Character(race: Race,
                      weapon: Weapon,
                      health: Double,
                      status: String = "Healthy") extends Playable {
}
