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
    private var sum = 0

    private fun sumTilt(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val ls = sumTilt(root.left)
        val rs = sumTilt(root.right)
        sum += Math.abs(ls - rs)
        return ls + rs + root.`val`
    }

    fun findTilt(root: TreeNode?): Int {
        sum = 0
        sumTilt(root)
        return sum
    }
}
