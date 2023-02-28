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
import kotlin.math.max

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return findDepth(root, 0)
    }

    private fun findDepth(node: TreeNode?, currentDepth: Int): Int {
        var localCurrentDepth = currentDepth
        if (node == null) {
            return 0
        }
        localCurrentDepth++
        return 1 + max(findDepth(node.left, localCurrentDepth), findDepth(node.right, localCurrentDepth))
    }
}
