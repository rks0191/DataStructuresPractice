package leetcode

case class RansomNoteRecursion() {
  private def remove(string:String,char:Char):String={
    string.foldLeft("",0){
      (c,t) => if(t == char && c._2 ==0) (c._1,1) else (c._1 + t , c._2)
    }._1
  }
  def canConstruct(ransomNote: String, magazine: String): Boolean={
    def _canConstruct(note:String,mag:String):Boolean={
      if (note.size ==0) true
      else{
        if(mag.contains(note(0))){
          val removed = remove(mag,note(0))
          _canConstruct(note.slice(1,note.size),removed)
        } else{
          false
        }
      }
    }
    _canConstruct(ransomNote,magazine)
  }
}
object RansomNoteRecursion{
  val ransomNote = "aa"
  val magazine = "aab"

  def main(args: Array[String]): Unit = {
    val rn = new RansomNoteRecursion()
    println(rn.remove("aab",'a'))
    println(rn.canConstruct(ransomNote,magazine))
  }
}
