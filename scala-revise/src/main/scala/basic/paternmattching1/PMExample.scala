package basic.paternmattching1

object PMExample extends App {

  def matcherFun(param: String): String = param match {
    case "Pradeep" => "Childhood friend"
    case "Vishal" => "Engineering Friend"
    case " KK " => "Office Friend"
    case _ => "Rest"
  }


  println(matcherFun("Joy"))
  println(matcherFun("Pradeep"))


  var gfs = Crush("Rani Mukharjee", 2003) ::  Crush("Rani Mukharjee", 1999) :: Crush("Ayesha Takia",2004) :: Crush("Amrita Rao", 2006) ::Nil

  for( gf <- gfs){
    gf match {
      case Crush("Rani Mukhargee", 2003) => println("Its Rani")
      case Crush("Rani Mukhargee", _ ) => println("Its Rani without year ")
      case _ => println("OK")
    }
  }
}



case class Crush(name:String, year: Int)