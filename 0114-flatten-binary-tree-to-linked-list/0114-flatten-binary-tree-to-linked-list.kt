/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun flatten(root: TreeNode?) {
        if (root != null) {
            findTail(root)
        }
    }

    private fun findTail(root: TreeNode): TreeNode {
        val left: TreeNode? = root.left
        val right: TreeNode? = root.right
        val tail: TreeNode
        // find the tail of left subtree, tail means the most left leaf
        if (left != null) {
            tail = findTail(left)
            // stitch the right subtree below the tail
            root.left = null
            root.right = left
            tail.right = right
        } else {
            tail = root
        }
        // find tail of the right subtree
        return if (tail.right == null) {
            tail
        } else {
            findTail(tail.right!!)
        }
    }
}
