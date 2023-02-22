package leetcode

case class InPlaceDuplicateRemover() {
  def removeDuplicate(array:Array[Int]):Array[Int]={
    def _removeDuplicate(initialArray:Array[Int],tailArray:Array[Int],headInt:Int):Array[Int]={
      if(initialArray.size ==0){
        tailArray
      } else{
        initialArray.headOption match{
          case Some(head) => if(head == headInt) {
            _removeDuplicate(initialArray.drop(1),tailArray,headInt)
          } else{
            _removeDuplicate(initialArray.drop(1),tailArray:+head,head)
          }
          case _ => _removeDuplicate(initialArray.drop(1),tailArray:+headInt,headInt)
        }
      }
    }
    _removeDuplicate(array,Array[Int](),0)
  }
}
object InPlaceDuplicateRemover{
  def main(args: Array[String]): Unit = {
    val a = Array[Int](1,2,4,5,5,6,6,6,7,7,7,8,8,8,8,8,9,9,9,9,10)
    val replacer = InPlaceDuplicateRemover()
    replacer.removeDuplicate(a).foreach(println)
  }
}
