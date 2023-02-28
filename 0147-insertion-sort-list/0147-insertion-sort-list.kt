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
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        var node = head
        while (node != null) {
            var prev = dummy
            while (prev.next != null && node.`val` > prev.next!!.`val`) {
                prev = prev.next!!
            }
            val temp = node.next
            node.next = prev.next
            prev.next = node
            node = temp
        }
        return dummy.next
    }
}
