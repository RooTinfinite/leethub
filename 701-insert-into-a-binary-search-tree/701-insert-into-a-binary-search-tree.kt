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
    fun insertIntoBST(
        root: TreeNode?,
        value: Int
    ): TreeNode? {
        if (root == null) {
            return TreeNode(value)
        }
        when {
            root.value < value -> root.right = insertIntoBST(root.right, value)
            root.value > value -> root.left = insertIntoBST(root.left, value)
        }
        return root
    }

    private val TreeNode.value get() = `val`
}
