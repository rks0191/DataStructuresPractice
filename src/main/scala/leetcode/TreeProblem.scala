package leetcode

case class TreeProblem() {
  def balancedStringSplit(s: String): Int = {
    def _balancedStringSplit(s:String,n:Int,loopCount:Int=0,rCount:Int=0,lCount:Int=0,answerCount:Int=0):Int={
      if(n==0){
        answerCount
      } else if(s.charAt(loopCount) =='R'){
        if(rCount ==lCount && loopCount!=0){
          _balancedStringSplit(s,n-1,loopCount+1,rCount+1,lCount,answerCount+1)
        } else{
          _balancedStringSplit(s,n-1,loopCount+1,rCount+1,lCount,answerCount)
        }
      } else{
        if(rCount ==lCount &&loopCount !=0){
          _balancedStringSplit(s,n-1,loopCount+1,rCount,lCount+1,answerCount+1)
        } else{
          _balancedStringSplit(s,n-1,loopCount+1,rCount,lCount+1,answerCount)
        }
      }
    }
    _balancedStringSplit(s,s.size) +1
  }
}
object TreeProblem{
  def main(args: Array[String]): Unit = {
    val s = "LLLLRRRR"
    val tree = TreeProblem()
    println(tree.balancedStringSplit(s))
  }
}