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
    private var forward: ListNode? = null
    fun reorderList(head: ListNode?) {
        forward = head
        dfs(head)
    }

    private fun dfs(node: ListNode?) {
        if (node != null) {
            dfs(node.next)
            if (forward != null) {
                val next = forward!!.next
                // even case: forward.next coincide with node
                if (next == node) {
                    node.next = null
                } else {
                    node.next = next
                }
                forward!!.next = node
                forward = node.next
            }
            // odd case: forward coincide with node
            if (forward == node) {
                forward!!.next = null
                forward = forward!!.next
            }
        }
    }
}
