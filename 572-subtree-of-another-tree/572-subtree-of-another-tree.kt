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
    private fun isSubtreeFound(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        if (root == null || subRoot == null) {
            return false
        }
        return if (root.`val` == subRoot.`val`) {
            isSubtreeFound(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)
        } else {
            false
        }
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        }
        return if (root == null || subRoot == null) {
            false
        } else isSubtreeFound(root, subRoot) ||
            isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot)
    }
}
