/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun preorder(root: Node?): List<Int> {
        val res: MutableList<Int> = ArrayList()
        preorderHelper(res, root)
        return res
    }

    private fun preorderHelper(res: MutableList<Int>, root: Node?) {
        if (root == null) {
            return
        }
        res.add(root.`val`)
        for (node in root.children) {
            preorderHelper(res, node)
        }
    }
}
