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
    private var j = 0
    private val map: MutableMap<Int, Int> = HashMap()
    fun get(key: Int): Int {
        return map[key]!!
    }

    private fun answer(preorder: IntArray, inorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end || j > preorder.size) {
            return null
        }
        val value = preorder[j++]
        val index = get(value)
        val node = TreeNode(value)
        node.left = answer(preorder, inorder, start, index - 1)
        node.right = answer(preorder, inorder, index + 1, end)
        return node
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        j = 0
        for (i in preorder.indices) {
            map[inorder[i]] = i
        }
        return answer(preorder, inorder, 0, preorder.size - 1)
    }
}
