package basic.traitExamples

object TraitRunner  extends  App {
  println( " Hello World")

  var p: Pradeep = new Pradeep
  var v: OnSite = new OnSite

  p.care(true)
  p.withBenefits(0)


  v.care(true)
  v.withBenefits(1000000)


}


trait FriendShip {
  def care(  uncoditional: Boolean = false )

  def withBenefits ( money:  BigDecimal ): Unit ={
    if( money > 10000){
      println(" Qualified")
    }
  }
}

class Pradeep extends FriendShip{
  override def care(uncoditional: Boolean): Unit = {
    println("Absolutely")
  }

  override def withBenefits ( money:  BigDecimal ): Unit ={
      println(" Never Mind ")
  }
}

class OnSite extends FriendShip{
  override def care(uncoditional: Boolean): Unit = {
    println("False")
  }

}