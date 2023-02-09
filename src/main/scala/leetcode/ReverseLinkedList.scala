package leetcode

import scala.annotation.tailrec

case class ReverseLinkedList() {
  def reverseLinkedList(head: ListNode):ListNode={
    @tailrec
    def _reverseLinkedList(node1:ListNode,resultNode:ListNode):ListNode={
      if(node1 == null){
        resultNode
      } else{
        _reverseLinkedList(node1.next,ListNode(node1.x,resultNode))
      }
    }
    _reverseLinkedList(head,null)
  }
}
object ReverseLinkedList{
  def main(args: Array[String]): Unit = {
    val linkedList = ListNode(1,ListNode(2,ListNode(3,ListNode(4,null))))
    val a = ReverseLinkedList()
    println(a.reverseLinkedList(linkedList))
  }
}
