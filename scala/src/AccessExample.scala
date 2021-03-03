import AccessExample.d
import a.ALevel
import a.b.BLevel

object AccessExample extends App{
  var aa: ALevel=new ALevel("pradeep")
  var d: String = "acv"
  println(aa.n)
  var bb: BLevel=new BLevel("vishal","Pradeep")
  println(bb)
}


object KnapSack01 extends App {
  println("Hello World")
  var arr = List("A", "B", "C", "D")
  k(0, "A",List())
  // expected A, AB,AC, AD, ABC
  def k(index : Int, cur: String, visited: List[List[String]]): Unit = {
    //println( s"\n$index\n$cur\n$visited\n"+arr.length)
    if ( index == arr.length-1) {
      val visited1= visited :+ List(cur)
      println(">>>>"+visited1)
    }
    else {
      val visited1= visited :+ List(cur)

      println("============================")
      for ( (i) <- index to (arr.length - 2)) {
        //println(i+">>>>"+arr(i+1))

        k( (i+1), arr(i+1), visited1 )
      }
    }
  }
}
