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
    private var ans = Int.MAX_VALUE
    private var prev = Int.MAX_VALUE

    fun getMinimumDifference(root: TreeNode?): Int {
        if (root == null) {
            return ans
        }
        getMinimumDifference(root.left)
        ans = Math.min(ans, Math.abs(root.`val` - prev))
        prev = root.`val`
        getMinimumDifference(root.right)
        return ans
    }
}
