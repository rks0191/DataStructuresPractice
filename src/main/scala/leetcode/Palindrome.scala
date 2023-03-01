package leetcode

class Palindrome {
  def longestPalindrome(s: String): Int = {
    val freq = s.groupMapReduce(k => k)(k => 1)(_ + _).values

    val (ans, odd) = freq.foldLeft(0, false) {
      case ((sum, odd), n) =>
        if (n % 2 == 0)
          (sum + n, odd)
        else (sum + n - 1, true)
    }

    if (odd) ans + 1 else ans
  }
}
object Palindrome{
  def main(args: Array[String]): Unit = {
    val a = "ccc"
    val palindrome = new Palindrome()
    println(palindrome.longestPalindrome(a))
  }
}
