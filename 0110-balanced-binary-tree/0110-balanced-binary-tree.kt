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
    fun isBalanced(root: TreeNode?): Boolean {
        // Empty Tree is balanced
        if (root == null) {
            return true
        }
        // Get max height of subtree child
        // Get max height of subtree child
        // compare height difference (cannot be more than 1)
        var leftHeight = 0
        var rightHeight = 0
        if (root.left != null) {
            leftHeight = getMaxHeight(root.left)
        }
        if (root.right != null) {
            rightHeight = getMaxHeight(root.right)
        }
        val heightDiff = Math.abs(leftHeight - rightHeight)
        // if passes height check
        //  - Check if left subtree is balanced and if the right subtree is balanced
        //  - If one of both are imbalanced, then the tree is imbalanced
        return heightDiff <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    private fun getMaxHeight(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var leftHeight = 0
        var rightHeight = 0
        // Left
        if (root.left != null) {
            leftHeight = getMaxHeight(root.left)
        }
        // Right
        if (root.right != null) {
            rightHeight = getMaxHeight(root.right)
        }
        return if (leftHeight > rightHeight) {
            1 + leftHeight
        } else {
            1 + rightHeight
        }
    }
}
