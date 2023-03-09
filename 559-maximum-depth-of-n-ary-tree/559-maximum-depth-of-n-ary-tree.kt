/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */
class Solution {
    private var max = 0

    fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }
        if (root.children.isEmpty()) {
            return 1
        }
        for (child in root.children) {
            findDepth(child, 1)
        }
        return max
    }

    private fun findDepth(n: Node?, d: Int) {
        if (!n!!.children.isEmpty()) {
            for (no in n.children) {
                findDepth(no, d + 1)
            }
        } else {
            max = Math.max(max, d + 1)
        }
    }
}
