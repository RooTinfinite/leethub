/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */
class Solution {
    fun cloneGraph(node: Node?): Node? {
        return cloneGraph(node, HashMap())
    }

    private fun cloneGraph(node: Node?, processedNodes: MutableMap<Node, Node?>): Node? {
        if (node == null) {
            return null
        } else if (processedNodes[node] != null) {
            return processedNodes[node]
        }
        val newNode = Node(node.`val`)
        processedNodes[node] = newNode
        newNode.neighbors = ArrayList()
        for (neighbor in node.neighbors) {
            val clonedNeighbor: Node? = cloneGraph(neighbor, processedNodes)
            if (clonedNeighbor != null) {
                newNode.neighbors.add(clonedNeighbor)
            }
        }
        return newNode
    }
}
