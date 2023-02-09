package leetcode


case class MidLinkedList() {
  def middleNode(head:ListNode):ListNode={
    def _getNodeSize(node:ListNode,number:Int=0):Int={
      if(node.next == null){
        number
      }
      else{
        _getNodeSize(node.next,number+1)
      }
    }
    def _getMiddleNode(lowerLimit:Int,upperLimit:Int,originalNode:ListNode):ListNode={
      if(lowerLimit == upperLimit || lowerLimit == upperLimit+1){
        originalNode
      } else{
        _getMiddleNode(lowerLimit+1,upperLimit-1,originalNode.next)
      }
    }
    _getMiddleNode(0,_getNodeSize(head),head)
  }
}
object MidLinkedList{
  def main(args: Array[String]): Unit = {
    val a= ListNode(1,ListNode(2,ListNode(3,ListNode(4,null))))
    val node = MidLinkedList()
    println(node.middleNode(a))

  }
}
