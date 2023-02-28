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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val inIndex = intArrayOf(inorder.size - 1)
        val postIndex = intArrayOf(postorder.size - 1)
        return helper(inorder, postorder, inIndex, postIndex, Int.MAX_VALUE)
    }

    private fun helper(`in`: IntArray, post: IntArray, index: IntArray, pIndex: IntArray, target: Int): TreeNode? {
        if (index[0] < 0 || `in`[index[0]] == target) {
            return null
        }
        val root = TreeNode(post[pIndex[0]--])
        root.right = helper(`in`, post, index, pIndex, root.`val`)
        index[0]--
        root.left = helper(`in`, post, index, pIndex, target)
        return root
    }
}
