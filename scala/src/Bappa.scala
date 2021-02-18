import Run.IntTimes

object Bappa extends App {
  4 method print("Add")


}

object  Run {
  /*implicit class IntTimes(var x: Int) {
    def times [A](f: =>A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }
      loop(x)

    }
  }*/
  implicit class IntTimes(var a: Int){
    def method [A](f: =>A):Unit={
      def loop( count: Int):Unit=
        if ( count ==  0){
          return f
          loop(count -1)
        }
      loop(a);

    }
  }
}
/*


implicit class IntTimes(x: Int) {
  def times [A](f: =>A): Unit = {
    def loop(current: Int): Unit =

      if(current > 0){
        f
        loop(current - 1)
      }
    loop(x)
  }
}*/
