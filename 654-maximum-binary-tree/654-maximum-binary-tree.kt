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
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return mbt(nums, 0, nums.size - 1)
    }

    private fun mbt(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r || l >= nums.size || r < 0) {
            return null
        }
        if (l == r) {
            return TreeNode(nums[r])
        }
        var max = Int.MIN_VALUE
        var maxidx = 0
        for (i in l..r) {
            if (nums[i] > max) {
                max = nums[i]
                maxidx = i
            }
        }
        val root = TreeNode(max)
        root.left = mbt(nums, l, maxidx - 1)
        root.right = mbt(nums, maxidx + 1, r)
        return root
    }
}
