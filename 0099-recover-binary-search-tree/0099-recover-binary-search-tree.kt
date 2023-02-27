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
    private var prev: TreeNode? = null
    private var first: TreeNode? = null
    private var second: TreeNode? = null

    fun recoverTree(root: TreeNode?) {
        evalSwappedNodes(root)
        val temp: Int = first!!.`val`
        first!!.`val` = second!!.`val`
        second!!.`val` = temp
    }

    private fun evalSwappedNodes(curr: TreeNode?) {
        if (curr == null) {
            return
        }
        evalSwappedNodes(curr.left)
        if (prev != null && prev!!.`val` > curr.`val`) {
            if (first == null) {
                first = prev
            }
            second = curr
        }
        prev = curr
        evalSwappedNodes(curr.right)
    }
}
