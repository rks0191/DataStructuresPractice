package leetcode


case class ExampleProblem(){
  def getSolution(array:Seq[Int]):Int={
    val set =array.filter(x => x > 0).toSet
    Range(1,array.size).foldLeft(1){
      (accum,b) => if(!set.contains(b)) b else accum
    }
  }
}
object ExampleProblem{
  def main(args: Array[String]): Unit = {
    val a =  ExampleProblem()
    println(a.getSolution(Seq[Int](1,3,6,4,1,2)))
  }
}
