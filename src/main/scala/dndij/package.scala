import com.sun.javafx.sg.prism.NGParallelCamera

package object dndij {

  // Game
  case class NDs(n: Int, d: Int)
  // Combat
  case class Attack(damage: Int, status: String)
  case class HpSummary(playerHealth: Int, npcHealth: Int, attacker: Character)

}
