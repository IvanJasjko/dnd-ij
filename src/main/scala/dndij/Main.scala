package dndij


object Main {

  def main(args: Array[String]): Unit = {

    for (_ <- 1 to 100) {
      val thrall = Orc("orc", Axe("axe"))
      if (thrall.enhancement != "none" && thrall.weapon.enhancement != "none")
        println(s"${thrall.getName} with ${thrall.weapon.getName}")
    }




  }
}
