/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        var head = head
        var nHead: ListNode? = ListNode(0)
        var nTail: ListNode? = ListNode(0)
        val ptr = nTail
        val temp = nHead
        while (head != null) {
            val nNext = head.next
            if (head.`val` < x) {
                nHead!!.next = head
                nHead = nHead.next
            } else {
                nTail!!.next = head
                nTail = nTail.next
            }
            head = nNext
        }
        nTail!!.next = null
        nHead!!.next = ptr!!.next
        return temp!!.next
    }
}
