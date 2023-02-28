/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return null
        }
        if (root.left != null && root.right != null) {
            root.left!!.next = root.right
        }
        if (root.next != null && root.right != null) {
            root.right!!.next = root.next!!.left
        }
        connect(root.left)
        connect(root.right)
        return root
    }
}
