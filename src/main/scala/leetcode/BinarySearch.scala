package leetcode

class BinarySearch{
  def search(nums: Array[Int], target: Int): Int = {
    nums.indexWhere(x => x == target)
  }
}
object BinarySearch {
  def main(args: Array[String]): Unit = {
    val  searchClass = new BinarySearch()
    val a = Array(-1,0,3,5,9,12)
    println(searchClass.search(a,9))
  }
}
