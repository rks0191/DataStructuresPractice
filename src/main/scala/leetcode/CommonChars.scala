package leetcode

case class CommonChars() {
  def commonChars(words:Array[String]):List[String] = {
    if (words.length == 0) {
      List()
    } else {
      words.foldLeft(words(0)) {
        (accum, b) => accum.intersect(b)
      }.toList.map(_.toString)
    }
  }
}
object CommonChars{
  def main(args: Array[String]): Unit = {
    val a = Array("bella","label","roller")
    val char = CommonChars()
    char.commonChars(a)
  }
}
