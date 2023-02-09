package leetcode

case class DuplicateRemover() {
  def removeDuplicates(sequence:Seq[String]):Seq[String]={
    sequence.foldLeft((scala.collection.mutable.Map[String,Int]())){
      (map,sequenceElement) =>
        map.get(sequenceElement) match{
          case Some(element) => map(sequenceElement) = element + 1 ; map
          case _ => map(sequenceElement) = 1 ; map
        }
    }.filter(_._2 ==1).map(_._1).toSeq
  }

}
// a = {}
//for i in element:
//   if a.get(i) == None:
//      a[i] = 1
//    else:
//      a[i] = a.get(i) + 1
//

object DuplicateRemover{
  def main(args: Array[String]): Unit = {
    val myArray = Seq("Infosys","Wipro","Infosys","xyz")
    val a = DuplicateRemover()
    a.removeDuplicates(myArray).foreach(println)
  }
}
