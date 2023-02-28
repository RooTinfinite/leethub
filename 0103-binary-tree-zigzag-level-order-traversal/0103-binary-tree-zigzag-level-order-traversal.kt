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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        if (root == null) {
            return result
        }
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        q.add(null)
        var zig = true
        var level = LinkedList<Int>()
        while (!q.isEmpty()) {
            var node: TreeNode? = q.remove()
            while (!q.isEmpty() && node != null) {
                if (zig) {
                    level.add(node.`val`)
                } else {
                    level.addFirst(node.`val`)
                }
                if (node.left != null) {
                    q.add(node.left)
                }
                if (node.right != null) {
                    q.add(node.right)
                }
                node = q.remove()
            }
            result.add(level)
            zig = !zig
            level = LinkedList()
            if (!q.isEmpty()) {
                q.add(null)
            }
        }
        return result
    }
}
