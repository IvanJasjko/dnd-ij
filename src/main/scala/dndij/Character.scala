package dndij

trait Playable {

}

case class Character(race: Race, weapon: Weapon) extends Playable
