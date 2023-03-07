/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {
    fun flatten(root: Node?): Node? {
        var currentNode = root
        while (currentNode != null) {
            if (currentNode.child != null) {
                appendToParent(currentNode, currentNode.next)
            }
            currentNode = currentNode.next
        }
        return root
    }

    private fun appendToParent(parent: Node, parentNext: Node?) {
        var currentNode = parent.child
        while (currentNode?.next != null) {
            if (currentNode.child != null) {
                appendToParent(currentNode, currentNode.next)
            }
            currentNode = currentNode.next
        }
        parent.next = parent.child
        parent.child?.prev = parent
        currentNode?.next = parentNext
        parentNext?.prev = currentNode
        parent.child = null
    }
}
