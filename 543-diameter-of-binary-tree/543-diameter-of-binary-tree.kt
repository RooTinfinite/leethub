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
    private var diameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        diameter = 0
        diameterOfBinaryTreeUtil(root)
        return diameter
    }

    private fun diameterOfBinaryTreeUtil(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val leftLength = if (root.left != null) 1 + diameterOfBinaryTreeUtil(root.left) else 0
        val rightLength = if (root.right != null) 1 + diameterOfBinaryTreeUtil(root.right) else 0
        diameter = Math.max(diameter, leftLength + rightLength)
        return Math.max(leftLength, rightLength)
    }
}
