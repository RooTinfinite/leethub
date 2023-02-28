/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        val bfsQueue: Queue<Node> = LinkedList()
        bfsQueue.offer(root)
        root.next = null
        var temp: Node?
        var prev: Node?
        while (!bfsQueue.isEmpty()) {
            val size = bfsQueue.size
            prev = null
            for (j in 0 until size) {
                temp = bfsQueue.poll()
                if (prev != null) prev.next = temp
                if (temp!!.left != null) bfsQueue.offer(temp.left)
                if (temp.right != null) bfsQueue.offer(temp.right)
                prev = temp
            }
        }
        return root
    }
}
