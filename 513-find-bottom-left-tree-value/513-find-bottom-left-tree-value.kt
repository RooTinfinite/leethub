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
    private fun func(root: TreeNode?, level: Int): IntArray? {
        if (root!!.left == null && root.right == null) {
            val a = IntArray(2)
            a[0] = root.`val`
            a[1] = level
            return a
        }
        var a: IntArray? = null
        var b: IntArray? = null
        if (root.left != null) {
            a = func(root.left, level + 1)
        }
        if (root.right != null) {
            b = func(root.right, level + 1)
        }
        return if (a == null) {
            b
        } else if (b == null) {
            a
        } else {
            if (a[1] >= b[1]) {
                a
            } else {
                b
            }
        }
    }

    fun findBottomLeftValue(root: TreeNode?): Int {
        val a = func(root, 0)
        return if (a != null && a.size > 0) {
            a[0]
        } else -1
    }
}
