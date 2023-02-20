package leetcode


/**Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters
 * from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.*/
case class RansomNote() {
  private def constructMap(string:String):Map[Char,Int]={
    string.map{
      char => (char,1)
    }.groupBy(_._1).map{
      case (char,sequence) => char -> sequence.size
    }
  }
  private def isAllTrue(bool1:Boolean,bool2:Boolean):Boolean ={
    bool1 && bool2
  }
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val ransomNoteMap = constructMap(ransomNote)
    val magazineMap = constructMap(magazine)
    ransomNoteMap.map{
      case(key,value) =>
        if (magazineMap.get(key).getOrElse(0) >= value) true else false
    }.reduceLeft(isAllTrue(_,_))
  }
}

object RansomNote {
  def main(args: Array[String]): Unit = {
    val ransomNote = "aa"
    val magazine = "aab"
    val note = new RansomNote()
    println(note.canConstruct(ransomNote,magazine))
  }
}
