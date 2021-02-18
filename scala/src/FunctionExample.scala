object FunctionExample extends App{

  def fun(  a: String, b: String="Default B" ){
    println("a "+a)
    println("b: "+b)
  }
  fun("a", "b")
  fun( b="BBB", a= "AAA")
  fun("AAAA")


  // pradeep calling vishal, chandra
  // it accept function in
  def pradeep( friend: (String)=> Unit, v: String): Unit = {
    println("\nCalling Friends\n")
    friend(v)
    println("--------------")
  }

  def vishal [A](str: A): Unit ={
    println("Hello "+str)
  }

  vishal("Chandra")


  pradeep(vishal,"233");



  var chandra = (message: String) =>{
    println(" Appended by Chandra :: "+message)
  }

  chandra(" Operation Parakram")

  // Partially applied function
  def ffoo( arg1: String, arg2: String ): Unit ={
    println( arg1+"\t"+arg2)
  }


  var ffoo22222222 = ffoo(_ :String, "Bachann")

  ffoo22222222("Amitab")
  ffoo22222222(" Aishwarya")
  ffoo22222222(" Teji " )


  // Get Some example of currying function

  var z:Array[String] = new Array[String](3)
  var tt = Array.range(10, 20)
  for( i <- tt){
    println ( i )
  }
}


