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
    private var max = Int.MIN_VALUE
    private fun helper(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        // to avoid the -ve values in left side we will compare them with 0
        val left = Math.max(0, helper(root.left))
        val right = Math.max(0, helper(root.right))
        val current: Int = root.`val` + left + right
        if (current > max) {
            max = current
        }
        return root.`val` + Math.max(left, right)
    }

    fun maxPathSum(root: TreeNode?): Int {
        helper(root)
        return max
    }
}
