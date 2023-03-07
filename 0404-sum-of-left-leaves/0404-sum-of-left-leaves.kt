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
    fun sumOfLeftLeaves(root: TreeNode): Int {
        fun dfs(root: TreeNode?, left: Boolean): Int {
            root ?: return 0
            if (root.left == null && root.right == null) {
                return if (left) {
                    root.`val`
                } else {
                    0
                }
            }
            return dfs(root.left, true) + dfs(root.right, false)
        }

        return dfs(root, false)
    }
}
