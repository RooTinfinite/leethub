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
import java.util.LinkedList
import java.util.Queue

/*
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
    fun largestValues(root: TreeNode?): List<Int> {
        val list: MutableList<Int> = ArrayList()
        val queue: Queue<TreeNode?> = LinkedList()
        if (root != null) {
            queue.offer(root)
            while (!queue.isEmpty()) {
                var max = Int.MIN_VALUE
                val size = queue.size
                for (i in 0 until size) {
                    val curr = queue.poll()
                    max = Math.max(max, curr!!.`val`)
                    if (curr.left != null) {
                        queue.offer(curr.left)
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right)
                    }
                }
                list.add(max)
            }
        }
        return list
    }
}
