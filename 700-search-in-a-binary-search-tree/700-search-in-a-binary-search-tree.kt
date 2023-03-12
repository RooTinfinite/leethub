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
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var root: TreeNode? = root
        while (root != null && root.`val` != `val`) {
            root = if (root.`val` > `val`) {
                root.left
            } else {
                root.right
            }
        }
        return root
    }
}
