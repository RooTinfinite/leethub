/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) {
            return root
        }
        val left: TreeNode? = lowestCommonAncestor(root.left, p, q)
        val right: TreeNode? = lowestCommonAncestor(root.right, p, q)
        if (left != null && right != null) {
            return root
        }
        return left ?: right
    }
}
