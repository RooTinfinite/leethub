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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result: MutableList<Int> = ArrayList()
        if (root == null) {
            return result
        }
        val stack: Stack<TreeNode> = Stack<TreeNode>()
        var current: TreeNode? = root
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                result.add(current.`val`)
                stack.push(current.right)
                current = current.left
            }
            current = stack.pop()
        }
        return result
    }
}
