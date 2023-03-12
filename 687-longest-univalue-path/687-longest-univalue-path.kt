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
    fun longestUnivaluePath(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val res = IntArray(1)
        preorderLongestSinglePathLen(root, res)
        return res[0]
    }

    private fun preorderLongestSinglePathLen(root: TreeNode?, res: IntArray): Int {
        if (root == null) {
            return -1
        }
        var left = preorderLongestSinglePathLen(root.left, res)
        var right = preorderLongestSinglePathLen(root.right, res)
        left = if (root.left == null || root.`val` == root.left!!.`val`) {
            left + 1
        } else {
            0
        }
        right = if (root.right == null || root.`val` == root.right!!.`val`) {
            right + 1
        } else {
            0
        }
        val longestPathLenPassingThroughRoot = left + right
        res[0] = res[0].coerceAtLeast(longestPathLenPassingThroughRoot)
        return left.coerceAtLeast(right)
    }
}
