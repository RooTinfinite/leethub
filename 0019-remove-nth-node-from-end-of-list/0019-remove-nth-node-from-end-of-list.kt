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
    private var n = 0

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        this.n = n
        val node = ListNode(0, head)
        removeNth(node)
        return node.next
    }

    private fun removeNth(node: ListNode?) {
        if (node?.next == null) {
            return
        }
        removeNth(node.next)
        n--
        if (n == 0) {
            node.next = node.next?.next
        }
    }
}
