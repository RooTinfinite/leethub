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
    fun isSymmetric(root: TreeNode?): Boolean {
        return if (root == null) {
            true
        } else helper(root.left, root.right)
    }

    private fun helper(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        if (leftNode == null || rightNode == null) {
            return leftNode == null && rightNode == null
        }
        return if (leftNode.`val` != rightNode.`val`) {
            false
        } else helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left)
    }
}
