package leetcode

import scala.collection.mutable

class IsoMorphicString (){
  /*
  *
  * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
  *  */
  private [this] def isEverythingTrue(bool1: Boolean, bool2: Boolean):Boolean ={
    bool1 && bool2
  }
  def isIsomorphic(string1:String,string2:String) : Boolean ={
    val myMap = new mutable.HashMap[Char,Char]()
    if(string1.size != string2.size){
      false
    } else{
      string1.zip(string2).map{
        case(char1,char2) => {
          (myMap.get(char1), myMap.find(_._2 == char2)) match{
            case (None,None) => myMap.foreach(println);myMap.put(char1,char2); true
            case (None,Some(c))  => if(c.equals(char2)) true else false
            case (Some(c),None) if (c != char2) => false
            case _ => true
          }
        }
      }
    }.reduceLeft(isEverythingTrue(_,_))
  }

}
object IsoMorphicString{
  def main(args: Array[String]): Unit = {
    val iso = new IsoMorphicString()
    val a : String = "badc"
    val b :String= "baba"
    println(iso.isIsomorphic(a,b))
  }
}
