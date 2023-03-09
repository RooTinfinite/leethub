/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    private var ans: ArrayList<Int>? = null

    fun postorder(root: Node?): List<Int> {
        ans = ArrayList()
        recursion(root)
        if (root != null) {
            ans!!.add(root.`val`)
        }
        return ans as ArrayList<Int>
    }

    private fun recursion(root: Node?) {
        if (root == null) {
            return
        }
        for (child in root.children) {
            recursion(child)
            ans!!.add(child?.`val`!!)
        }
    }
}
