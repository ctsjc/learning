package a.b

class BLevel (n1:String, n2:String ){
  private var bb:String = n1
  private[a] var aa : String = n2
}
object Runner extends App{
  var bb: BLevel=new BLevel("vishal","Pradeep")
  println( bb.aa )
}
