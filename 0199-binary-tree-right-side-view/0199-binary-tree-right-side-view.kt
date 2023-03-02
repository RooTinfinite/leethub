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
    fun rightSideView(root: TreeNode?): List<Int> {
        val list: MutableList<Int> = ArrayList()
        recurse(root, 0, list)
        return list
    }

    private fun recurse(node: TreeNode?, level: Int, list: MutableList<Int>) {
        if (node != null) {
            if (list.size < level + 1) {
                list.add(node.`val`)
            }
            recurse(node.right, level + 1, list)
            recurse(node.left, level + 1, list)
        }
    }
}
