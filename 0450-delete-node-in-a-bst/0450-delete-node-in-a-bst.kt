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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return root
        // find the correct node
        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            // case 1 - both children are null
            if (root.left == null && root.right == null) {
                return null
            } else if (root.left != null && root.right != null) { // case 2 - both children are NOT null
                val successor = minimum(root.right!!) // inorder successor
                root.right = deleteNode(root.right, successor)
                root.`val` = successor
            } else { // case 3 - only one of the child is null
                return root.left ?: root.right
            }
        }
        return root
    }

    private fun minimum(root: TreeNode): Int {
        var node = root
        while (node.left != null) {
            node = node.left!!
        }
        return node.`val`
    }
}
