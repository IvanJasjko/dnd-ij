package dndij

trait Playable {

}

trait Race extends Enchanted with Name {
  val desc: String
  val health: Int
  val armor: Int

  def getName: String = {
    enhancement match {
      case "none" => desc.capitalize
      case _ => enhancement.capitalize + " " + desc.capitalize
    }
  }
}

case class Orc(desc: String, weapon: Weapon) extends Race {
  val (health, armor) = (1, 1)
}

case class Goblin(desc: String, weapon: Weapon) extends Race {
  val (health, armor) = (1, 1)
}

case class HobGoblin(desc: String, weapon: Weapon) extends Race {
  val (health, armor) = (1, 1)
}

case class Human(desc: String, weapon: Weapon) extends Race {
  val (health, armor) = (1, 1)
}


