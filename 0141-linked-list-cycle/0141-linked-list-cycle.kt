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
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) {
            return false
        }
        var slow = head
        var faster = head
        while (slow?.next != null && faster?.next?.next != null) {
            slow = slow.next
            faster = faster.next?.next
            if (slow == faster) {
                return true
            }
        }
        return false
    }
}
