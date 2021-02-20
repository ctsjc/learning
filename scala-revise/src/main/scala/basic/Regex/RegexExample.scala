package basic.Regex

object RegexExample extends App {
  val pattern = "Scala".r
  val str = "Scala is Scalable and cool"

  println(pattern findFirstIn str)
  println((pattern findAllIn  str).toList)
  println(pattern findPrefixMatchOf str)
}

