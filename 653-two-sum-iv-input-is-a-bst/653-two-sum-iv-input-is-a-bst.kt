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
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if (root == null) {
            return false
        }
        val res: MutableList<Int> = ArrayList()
        inOrder(res, root)
        var i = 0
        var j = res.size - 1
        while (i < j) {
            val val1 = res[i]
            val val2 = res[j]
            if (val1 + val2 == k) {
                return true
            } else if (val1 + val2 < k) {
                i++
            } else {
                j--
            }
        }
        return false
    }

    private fun inOrder(res: MutableList<Int>, root: TreeNode?) {
        if (root == null) {
            return
        }
        inOrder(res, root.left)
        res.add(root.`val`)
        inOrder(res, root.right)
    }
}
