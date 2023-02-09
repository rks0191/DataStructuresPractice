package leetcode

/** You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * */

case class Greedy() {
  def maxProfit(prices: Array[Int]): Int = {
    def loop(ps: List[Int], max: Int, buy: Int): Int = {
      ps match {
        case p :: px =>
          loop(px, math.max(max, p - buy), math.min(buy, p))
        case _ => max
      }
    }

    if (prices.nonEmpty) loop(prices.toList, 0, prices.head)
    else 0

  }

}
object Greedy{
  def main(args: Array[String]): Unit = {
    val a= Array(7,1,2,5)
    val algo = Greedy()
    println(algo.maxProfit(a))
  }
}
