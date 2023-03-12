import java.util.LinkedList
import java.util.Objects
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
    internal class Pair(node: TreeNode, idx: Int) {
        var node: TreeNode
        var idx: Int

        init {
            this.node = node
            this.idx = idx
        }
    }

    fun widthOfBinaryTree(root: TreeNode): Int {
        val q: Queue<Pair> = LinkedList()
        q.add(Pair(root, 0))
        var res = 1
        while (!q.isEmpty()) {
            val qSize = q.size
            var lastIdx = 0
            var firstIdx = 0
            for (i in 0 until qSize) {
                val temp = q.poll()
                if (i == 0) {
                    firstIdx = temp.idx
                }
                if (i == qSize - 1) {
                    lastIdx = Objects.requireNonNull(temp).idx
                }
                if (Objects.requireNonNull(temp).node.left != null) {
                    q.add(Pair(temp.node.left!!, 2 * temp.idx + 1))
                }
                if (temp.node.right != null) {
                    q.add(Pair(temp.node.right!!, 2 * temp.idx + 2))
                }
            }
            res = (lastIdx - firstIdx + 1).coerceAtLeast(res)
        }
        return res
    }
}
