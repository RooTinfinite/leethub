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
        if (head == null) {
            return null
        }
        var current: ListNode = head
        var next = current.next
        while (null != next) {
            if (current.`val` == next.`val`) {
                current.next = next.next
            } else {
                current = next
            }
            next = current.next
        }
        return head
    }
}
