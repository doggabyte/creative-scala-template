import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

// To use this example, open the SBT console and type:
//
// Example.image.draw
object Xlnt {
  val image = triangle(30,30) fillColor Color.red above (triangle(30,30) fillColor Color.green beside triangle(30,30) fillColor Color.blue)

  def main(args: Array[String]): Unit = {
    image.draw
  }
}
