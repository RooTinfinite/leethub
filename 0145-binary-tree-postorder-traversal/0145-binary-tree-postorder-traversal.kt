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
    fun postorderTraversal(root: TreeNode?): MutableList<Int> {
        if (root == null) {
            return ArrayList()
        }
        val res = postorderTraversal(root.left)
        res.addAll(postorderTraversal(root.right))
        res.add(root.`val`)
        return res
    }
}
