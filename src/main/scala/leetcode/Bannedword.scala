package leetcode

case class Bannedword() {
  def getMax(tuple: (String, Int), tuple1: (String, Int)): (String,Int) ={
    if(tuple._2 > tuple1._2) tuple else tuple1
  }
  def mostCommonWord(paragraph: String, banned: Array[String]): String = {
    val paragraphArray = paragraph.split("[^-A-Za-z]+").map(_.toLowerCase())
      .groupMapReduce(k => k)(_ => 1)(_+_)

    val someArray = paragraphArray.foldLeft(scala.collection.mutable.Map[String,Int]()){
      (accum,element) => banned.find(x => x == element._1) match{
        case Some(_) => accum
        case None => accum + element
      }
    }
    someArray.reduceLeft(getMax(_,_))._1
  }
}
object Bannedword{
  def main(args: Array[String]): Unit = {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = Array("hit")
    val bannedword = Bannedword()
    println(bannedword.mostCommonWord(paragraph,banned))
  }
}
