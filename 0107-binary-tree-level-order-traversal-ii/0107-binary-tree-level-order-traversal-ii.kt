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
    private val order: MutableList<MutableList<Int>> = ArrayList()
    fun levelOrderBottom(root: TreeNode?): List<MutableList<Int>> {
        getOrder(root, 0)
        Collections.reverse(order)
        return order
    }

    fun getOrder(root: TreeNode?, level: Int) {
        if (root != null) {
            if (level + 1 > order.size) {
                order.add(ArrayList())
            }
            order[level].add(root.`val`)
            getOrder(root.left, level + 1)
            getOrder(root.right, level + 1)
        }
    }
}
