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
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var node1 = headA
        var node2 = headB
        while (node1 !== node2) {
            node1 = if (node1 == null) headB else node1.next
            node2 = if (node2 == null) headA else node2.next
        }
        return node1
    }
}
