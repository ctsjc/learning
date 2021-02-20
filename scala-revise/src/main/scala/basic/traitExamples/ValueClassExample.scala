package basic.traitExamples

object ValueClassExample extends App {
  var mylove  =  new Love("wife");
  println(mylove.name1)
}

class Love(val name1: String)  extends AnyVal{
}
