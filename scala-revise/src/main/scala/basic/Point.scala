package basic

class Point(x1: Int, y1: Int) {
  var x: Int = x1
  var y: Int = y1

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
    println("Point x location : " + x)
    println("Point y location : " + y)
  }
}


object Demo {
  def main(args: Array[String]): Unit ={
    var pt: Point=new Point(10, 20)

    pt.move(1000, 1000)

  }
}