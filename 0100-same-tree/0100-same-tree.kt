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
    private fun trav(n: TreeNode?, m: TreeNode?): Boolean {
        return if (n != null && m != null) {
            if (n.`val` != m.`val`) {
                false
            } else trav(n.left, m.left) && trav(n.right, m.right)
        } else {
            n == null && m == null
        }
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        } else if (p == null || q == null) {
            return false
        }
        return trav(p, q)
    }
}
