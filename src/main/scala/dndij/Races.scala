package dndij

trait Race extends Enchanted with Name {
  val name: String
  val health: Int
  val armor: Int

  def getName: String = {
    enhancement match {
      case "none" => name.capitalize
      case _ => enhancement.capitalize + " " + name.capitalize
    }
  }
}

object Orc extends Race {
  val name = "orc"
  val (health, armor) = (10, 3)
}

object Goblin extends Race {
  val name = "goblin"
  val (health, armor) = (5, 1)
}

object HobGoblin extends Race {
  val name = "hobgoblin"
  val (health, armor) = (7, 2)
}

object Human extends Race {
  val name = "human"
  val (health, armor) = (15, 3)
}


