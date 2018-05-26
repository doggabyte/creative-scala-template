import doodle.core._
import doodle.core.Image._
import doodle.syntax._
import doodle.jvm.Java2DFrame._
import doodle.backend.StandardInterpreter._

package doggabyte {
  object Xlnt {
    val zelda = triangle(30,30) fillColor Color.red above (triangle(30,30) fillColor Color.green beside triangle(30,30) fillColor Color.blue)
    val arch = circle(100) fillColor Color.white above rectangle(10, 60) fillColor Color.white above rectangle(200, 70) fillColor Color.green
    val house = triangle(100, 90) fillColor Color.brown above rectangle(100, 100) fillColor Color.red

    def main(args: Array[String]): Unit = {
      zelda.draw
      arch.draw
      house.draw
    }

    def cross(count: Int): Image = {
      val unit = Image.circle(20)
      count match {
        case 0 => unit
        case n => unit beside (unit above cross(n-1) above unit) beside unit
      }
    }

    def evilTriangle(count: Int): Image = {
      val triangle = Image.triangle(8, 8) lineColor Color.black
      count match {
        case 0 => triangle above (triangle beside triangle)
        case n =>
          val unit = evilTriangle(n-1)
          unit above (unit beside unit)
      }
    }
  }
}