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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var localRoot: TreeNode? = root
        val result: MutableList<List<Int>> = ArrayList()
        if (localRoot == null) {
            return result
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(localRoot)
        queue.add(null)
        var level: MutableList<Int> = ArrayList()
        while (!queue.isEmpty()) {
            localRoot = queue.remove()
            while (!queue.isEmpty() && localRoot != null) {
                level.add(localRoot.`val`)
                if (localRoot.left != null) {
                    queue.add(localRoot.left)
                }
                if (localRoot.right != null) {
                    queue.add(localRoot.right)
                }
                localRoot = queue.remove()
            }
            result.add(level)
            level = ArrayList()
            if (!queue.isEmpty()) {
                queue.add(null)
            }
        }
        return result
    }
}
