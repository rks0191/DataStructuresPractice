package leetcode

case class RunningSum() {
  val sequence: scala.collection.mutable.Seq[Int] = scala.collection.mutable.Seq[Int]()
  def getSum(array:Seq[Int]):Seq[Int] ={
    array.foldLeft((Seq[Int](),0)){
      (accum,b) => (accum._1 :+ accum._2+b, accum._2+b)
    }}._1
}

object RunningSum{
  def main(args: Array[String]): Unit = {
    val a = Seq(1,2,3,4)
    a match{
      case head:: tail => head
      case _ => print("I dont know")
    }
    val b = RunningSum().getSum(a)
    print(b)
  }
}
