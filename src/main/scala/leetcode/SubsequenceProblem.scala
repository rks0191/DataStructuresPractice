package leetcode

import scala.annotation.tailrec

/*
*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
* of the characters without disturbing the relative positions of the remaining characters.
*  (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
case class SubSequenceProblem() {
  def isSubSequence(string2: String, string1: String): Boolean = {
    def _isSubSequence(a: String, b: String, m: Int, n: Int): Boolean = {
      if (m == 0) true
      else {
        if (n == 0) false
        else {
          if (a.charAt(m - 1) == b.charAt(n - 1)) {
            _isSubSequence(a, b, m - 1, n - 1)
          } else {
            _isSubSequence(a, b, m, n - 1)
          }
        }
      }
    }

    _isSubSequence(string2, string1, string2.length, string1.length)
  }
}

object SubSequenceProblem{
  def main(args: Array[String]): Unit = {
    val a =  SubSequenceProblem()
    println(a.isSubSequence("abc","ahbgdc"))
  }
}
