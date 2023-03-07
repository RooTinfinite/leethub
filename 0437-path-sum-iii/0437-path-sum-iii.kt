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
    private var count = 0

    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }
        helper(root, targetSum, 0)
        pathSum(root.left, targetSum)
        pathSum(root.right, targetSum)
        return count
    }

    fun helper(node: TreeNode, targetSum: Int, currSum: Long) {
        var currSum = currSum
        currSum += node.`val`
        if (targetSum.toLong() == currSum) {
            count++
        }
        if (node.left != null) {
            helper(node.left!!, targetSum, currSum)
        }
        if (node.right != null) {
            helper(node.right!!, targetSum, currSum)
        }
    }
}
