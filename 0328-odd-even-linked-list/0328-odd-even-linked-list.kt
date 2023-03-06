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
    fun oddEvenList(head: ListNode?): ListNode? {
        val odd = ListNode(0)
        val even = ListNode(0)
        var oddPointer = odd
        var evenPointer = even
        var pointer = head
        var count = 0
        while (pointer != null) {
            if (count % 2 == 0) {
                oddPointer.next = pointer
                oddPointer = oddPointer.next!!
            } else {
                evenPointer.next = pointer
                evenPointer = evenPointer.next!!
            }
            val next = pointer.next
            pointer.next = null
            pointer = next
            count++
        }
        oddPointer.next = even.next
        return odd.next
    }
}
