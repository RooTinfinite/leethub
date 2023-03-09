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
    private val cache = mutableMapOf<Int, Int>()

    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        treeSum(root)
        if (cache.isEmpty()) {
            return IntArray(0)
        }
        val max = cache.maxBy { it.value }?.value
        return cache.filter { it.value == max }.map { it.key }.toIntArray()
    }

    private fun treeSum(node: TreeNode?): Int {
        if (node == null) {
            return 0
        } else {
            val sum = node.`val` + treeSum(node.left) + treeSum(node.right)
            cache[sum] = cache.getOrDefault(sum, 0) + 1
            return sum
        }
    }
}
