package leetcode

case class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

}

case class MergeLinkedList() {
  def mergeTwoLists(list1: ListNode, list2: ListNode): ListNode = {
    (list1, list2) match {
      case (null, _) => list2
      case (_, null) => list1
      case (l1, l2) => {
        if (l1.x < l2.x)  ListNode(l1.x, mergeTwoLists(l1.next, l2))
        else  ListNode(l2.x, mergeTwoLists(l1, l2.next))
      }
    }
  }
}

object MergeLinkedList{
  def main(args: Array[String]): Unit = {
    val a =  MergeLinkedList()
    val list1 = ListNode(1,ListNode(3,ListNode(5,ListNode(7,null))))
    val list2 = ListNode(2,ListNode(3,ListNode(4,null)))
    println(a.mergeTwoLists(list1,list2))
  }
}