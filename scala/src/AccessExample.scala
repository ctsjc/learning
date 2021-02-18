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
