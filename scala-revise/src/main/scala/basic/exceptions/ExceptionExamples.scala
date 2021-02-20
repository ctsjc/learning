package basic.exceptions

import java.io.{FileNotFoundException, FileReader, IOException}

object ExceptionExamples extends App {
  try {
    val f = new FileReader("input.txt")
  } catch {
    case e : FileNotFoundException => println("Its file not found ")
    case e : IOException => println("Its IO Exception")
  }
}
