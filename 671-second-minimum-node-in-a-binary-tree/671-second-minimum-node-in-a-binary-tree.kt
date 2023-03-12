import kotlin.math.abs

/*
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
    var min = Int.MAX_VALUE
    var secMin = -1
    var diff = Int.MAX_VALUE
    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root == null) {
            return -1
        }
        if (root.`val` < min) {
            min = root.`val`
        }
        if (root.`val` != min && abs(root.`val` - min) < diff) {
            secMin = root.`val`
            diff = abs(root.`val` - min)
        }
        findSecondMinimumValue(root.left)
        findSecondMinimumValue(root.right)
        return secMin
    }
}
