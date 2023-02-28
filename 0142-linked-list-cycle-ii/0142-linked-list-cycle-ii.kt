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
    fun detectCycle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }
        var slow = head
        var fast = head
        while (fast?.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
            // intersected inside the loop.
            if (slow == fast) {
                break
            }
        }
        if (fast?.next == null) {
            return null
        }
        slow = head
        while (slow != fast) {
            slow = slow!!.next
            fast = fast!!.next
        }
        return slow
    }
}
