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
    fun trimBST(root: TreeNode?, l: Int, r: Int): TreeNode? {
        if (root == null) {
            return root
        }
        if (root.`val` > r) {
            return trimBST(root.left, l, r)
        }
        if (root.`val` < l) {
            return trimBST(root.right, l, r)
        }
        root.left = trimBST(root.left, l, r)
        root.right = trimBST(root.right, l, r)
        return root
    }
}
