import kotlin.math.abs

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
    private var prev = -1
    private var min = Int.MAX_VALUE
    fun minDiffInBST(root: TreeNode?): Int {
        if (root == null) {
            return min
        }
        minDiffInBST(root.left)
        if (prev != -1) {
            min = min.coerceAtMost(abs(root.`val` - prev))
        }
        prev = root.`val`
        minDiffInBST(root.right)
        return min
    }
}
