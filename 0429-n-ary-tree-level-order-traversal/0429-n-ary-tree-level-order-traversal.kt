/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */
class Solution {
    fun levelOrder(root: Node?): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        if (root == null) {
            return result
        }
        val queue: Queue<Node> = LinkedList<Node>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val size: Int = queue.size
            val level: MutableList<Int> = ArrayList()
            for (i in 0 until size) {
                val currentNode: Node = queue.poll()
                level.add(currentNode.`val`)
                for (child in currentNode.children) {
                    queue.offer(child)
                }
            }
            result.add(level)
        }
        return result
    }
}