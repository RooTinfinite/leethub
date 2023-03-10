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
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null) {
            return root2
        }
        return if (root2 == null) {
            root1
        } else TreeNode(
            root1.`val` + root2.`val`,
            mergeTrees(root1.left, root2.left),
            mergeTrees(root1.right, root2.right)
        )
    }
}
