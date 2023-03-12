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
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode> {
        val map: MutableMap<String, Int> = HashMap()
        val list: MutableList<TreeNode> = ArrayList<TreeNode>()
        helper(root, map, list)
        return list
    }

    private fun helper(root: TreeNode?, map: MutableMap<String, Int>, list: MutableList<TreeNode>): String {
        if (root == null) {
            return "#"
        }
        val key = helper(root.left, map, list) + "#" + helper(root.right, map, list) + "#" + root.`val`
        map[key] = map.getOrDefault(key, 0) + 1
        if (map[key] == 2) {
            list.add(root)
        }
        return key
    }
}
