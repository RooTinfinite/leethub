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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var d = 0
        while (!queue.isEmpty()) {
            val size: Int = queue.size
            for (i in 0 until size) {
                val current: TreeNode = queue.poll()
                if (current.left == null && current.right == null && d > 0) {
                    return d + 1
                }
                if (current.right != null) {
                    queue.add(current.right)
                }
                if (current.left != null) {
                    queue.add(current.left)
                }
            }
            d++
        }
        return d
    }
}
