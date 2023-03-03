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
    private var k = 0
    private var count = 0
    private var `val` = 0
    fun kthSmallest(root: TreeNode, k: Int): Int {
        this.k = k
        calculate(root)
        return `val`
    }

    private fun calculate(node: TreeNode) {
        if (node.left == null && node.right == null) {
            count++
            if (count == k) {
                `val` = node.`val`
            }
            return
        }
        if (node.left != null) {
            calculate(node.left!!)
        }
        count++
        if (count == k) {
            `val` = node.`val`
            return
        }
        if (node.right != null) {
            calculate(node.right!!)
        }
    }
}
