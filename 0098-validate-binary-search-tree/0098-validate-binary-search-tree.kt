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
    fun isValidBST(root: TreeNode?): Boolean {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    // we will send a valid range and check whether the root lies in the range
    // and update the range for the subtrees
    private fun solve(root: TreeNode?, left: Long, right: Long): Boolean {
        if (root == null) {
            return true
        }
        return if (root.`val` <= left || root.`val` >= right) {
            false
        } else solve(root.left, left, root.`val`.toLong()) && solve(root.right, root.`val`.toLong(), right)
    }
}
