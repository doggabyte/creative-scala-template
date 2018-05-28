package doggabyte {

  import doodle.core._
  import doodle.core.Image._
  import doodle.core.Point._
  import doodle.core.PathElement._
  import doodle.syntax._
  import doodle.jvm.Java2DFrame._
  import doodle.backend.StandardInterpreter._

  object Xlnt {

    def main(args: Array[String]): Unit = {

      /*
      println(ascending(666))
      println(fill(5, Image))
      println(List(4, 9, 16).map(_*2))
      println(double(List(4, 9, 16)))
      //println(Nil.fold(0)(_*_))
      println(List(1, 2, 3, 4).reduceLeft(_*_))
      println(product(List(1, 2, 3, 4, 5)))
      println(contains(List(1,2,3), 3))
      println(contains(List("one", "two", "three"), "four"))
      */
      house.draw

    }

    def contains[T](list : List[T], element: T) : Boolean = {
      list match {
        case Nil => false
        case head :: tail => (head == element) || contains(tail, element)
      }
    }

    def product(list : List[Int]) : Int = {
      list match {
        case Nil => 1
        case list => list.reduceLeft(_*_)
      }
    }

    def double(list : List[Int]) : List[Int] = {
      list match {
        case Nil => Nil
        case head :: tail => (head*2) :: double(tail)
      }
    }

    def fill[T](n : Int, t : T) : List[T] = {
      n match {
        case 0 => Nil
        case n => t :: fill(n-1, t)
      }
    }

    def ascending(n : Int) : List[Int] = {
      def irritating(i: Int, i1: Int): List[Int] = {
        i match {
          case 0 => Nil
          case i => i1 :: irritating(i-1, i1+1)
        }
      }
      irritating(n, 1)
    }

    def descending(n : Int) : List[Int] = {
      n match {
        case 0 => Nil
        case n => n :: descending(n-1)
      }
    }

    def eights(n : Int) : List[Int] = {
      n match {
        case 0 => Nil
        case n => 8 :: eights(n-1)
      }
    }

    def pathPen : Path = {
      closedPath(List(
        moveTo(polar(54, 4.degrees)),
        lineTo(polar(54, 23.degrees)),
        lineTo(polar(54, 56.degrees)),
        lineTo(polar(54, 128.degrees)),
        lineTo(polar(54, 360.degrees))
      ))
    }

    def chessBoard : Image = {
      val blackSquare = square(30) fillColor Color.black
      val whiteSquare = square(30) fillColor Color.white
      val twoSquare = (whiteSquare above blackSquare) beside (blackSquare above whiteSquare)
      val fourSquare = (twoSquare above twoSquare) beside (twoSquare above twoSquare)
      val eightSquare = (fourSquare above fourSquare) beside (fourSquare above fourSquare)
      eightSquare
    }

    def cross(count : Int): Image = {
      val unit = Image.circle(20)
      count match {
        case 0 => unit
        case n => unit beside (unit above cross(n-1) above unit) beside unit
      }
    }

    def evilTriangle(count : Int): Image = {
      val triangle = Image.triangle(8, 8) lineColor Color.black
      count match {
        case 0 => triangle above (triangle beside triangle)
        case n =>
          val triforce = evilTriangle(n-1)
          triforce above (triforce beside triforce)
      }
    }

    def listSort(li : List[Int]) : List[Int] = {
      if (li.size < 2) return li
      val pivot = li.head
      val (left, right) = li.partition(_< pivot)
      println(left, pivot, right.tail)
      listSort(left) ::: pivot :: listSort(right.tail)
    }

    def vectorSort(seq : Seq[Int]) : Seq[Int] = {
      if (seq.size < 2) return seq
      val pivotPos = seq.size / 2
      val pivot = seq.apply(pivotPos)
      val (left, right) = seq.patch(pivotPos, Nil, 1).partition(_< pivot)
      println(left, pivot, right)
      (vectorSort(left):+ pivot) ++ vectorSort(right)
    }

    def vectorQuickSort(seq : Seq[Int]) : Seq[Int] = {
      if (seq.size < 2) return seq
      val pivotPos = scala.util.Random.nextInt(seq.size)
      val pivot = seq.apply(pivotPos)
      val (left, right) = seq.patch(pivotPos, Nil, 1).partition (_< pivot)
      println(left, pivot, right)
      (vectorQuickSort(left):+ pivot) ++ vectorQuickSort(right)
    }

    def zelda : Image = triangle(30,30) fillColor Color.rgb(255.uByte, 0.uByte, 0.uByte) above (triangle(30,30) fillColor Color.rgb(0.uByte, 255.uByte, 0.uByte) beside triangle(30,30) fillColor Color.rgb(0.uByte, 0.uByte, 255.uByte))
    def arch : Image = circle(100) fillColor Color.white above rectangle(10, 60) fillColor Color.white above rectangle(200, 70) fillColor Color.green
    def house : Image = triangle(100, 90) fillColor Color.brown above rectangle(100, 100) fillColor Color.red
  }
}
