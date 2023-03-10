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
    fun tree2str(t: TreeNode?): String {
        if (t == null) {
            return ""
        }
        val sb = StringBuilder()
        preorder(t, sb)
        return sb.toString()
    }

    private fun preorder(root: TreeNode?, sb: StringBuilder) {
        if (root == null) {
            return
        }
        sb.append(root.`val`)
        if (root.left != null) {
            sb.append("(")
            preorder(root.left, sb)
            sb.append(")")
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()")
            }
            sb.append("(")
            preorder(root.right, sb)
            sb.append(")")
        }
    }
}
