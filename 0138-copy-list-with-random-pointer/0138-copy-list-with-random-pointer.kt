/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */
class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return null
        }
        // first pass to have a clone node point to the next node. ie A->B becomes A->clonedNode->B
        var curr: Node? = head
        while (curr != null) {
            val clonedNode = Node(curr.`val`)
            clonedNode.next = curr.next
            curr.next = clonedNode
            curr = clonedNode.next
        }
        curr = head
        // second pass to make the cloned node's random pointer point to the orginal node's randome
        // pointer.
        // ie. A's random pointer becomes ClonedNode's random pointer
        while (curr != null) {
            if (curr.random != null) {
                curr.next?.random = curr.random!!.next
            } else {
                curr.next?.random = null
            }
            curr = curr.next?.next
        }
        curr = head
        // third pass to restore the links and return the head of the cloned nodes' list.
        var newHead: Node? = null
        while (curr != null) {
            var clonedNode: Node
            if (newHead == null) {
                clonedNode = curr.next!!
                newHead = clonedNode
            } else {
                clonedNode = curr.next!!
            }
            curr.next = clonedNode.next
            if (curr.next != null) {
                clonedNode.next = curr.next!!.next
            } else {
                clonedNode.next = null
            }
            curr = curr.next
        }
        return newHead
    }
}
