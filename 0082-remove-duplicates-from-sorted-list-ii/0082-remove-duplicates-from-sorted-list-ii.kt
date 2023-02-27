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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }
        val dummy = ListNode(0)
        var prev: ListNode? = dummy
        prev!!.next = head
        var curr = head.next
        while (curr != null) {
            var flagFoundDuplicate = false
            while (curr != null && prev!!.next!!.`val` == curr.`val`) {
                flagFoundDuplicate = true
                curr = curr.next
            }
            if (flagFoundDuplicate) {
                prev!!.next = curr
                if (curr != null) {
                    curr = curr.next
                }
            } else {
                prev = prev!!.next
                prev!!.next = curr
                curr = curr!!.next
            }
        }
        return dummy.next
    }
}

