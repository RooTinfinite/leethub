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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res: MutableList<List<Int>> = ArrayList()
        if (root == null) {
            return res
        }
        recur(res, ArrayList(), 0, targetSum, root)
        return res
    }

    private fun recur(
        res: MutableList<List<Int>>,
        al: ArrayList<Int>,
        sum: Int,
        targetSum: Int,
        root: TreeNode?
    ) {
        var sum = sum
        if (root == null) {
            return
        }
        al.add(root.`val`)
        sum += root.`val`
        if (sum == targetSum && root.left == null && root.right == null) {
            res.add(ArrayList(al))
        }
        recur(res, al, sum, targetSum, root.left)
        recur(res, al, sum, targetSum, root.right)
        al.removeAt(al.size - 1)
    }
}
