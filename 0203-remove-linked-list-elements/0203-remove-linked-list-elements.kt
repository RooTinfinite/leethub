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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val sentinel = ListNode(-1)
        sentinel.next = head
        var next = head
        var prev = sentinel
        while (next != null) {
            if (next.`val` == `val`) {
                prev.next = next.next
            } else {
                prev = next
            }
            next = next.next
        }
        return sentinel.next
    }
}
