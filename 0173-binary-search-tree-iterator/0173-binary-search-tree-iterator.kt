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
class BSTIterator(root: TreeNode?) {
    private var node: TreeNode?

    init {
        node = root
    }

    operator fun next(): Int {
        var res = -1
        while (node != null) {
            if (node!!.left != null) {
                var rightMost: TreeNode? = node!!.left
                while (rightMost!!.right != null) {
                    rightMost = rightMost.right
                }
                rightMost.right = node
                val temp: TreeNode? = node!!.left
                node!!.left = null
                node = temp
            } else {
                res = node!!.`val`
                node = node!!.right
                return res
            }
        }
        return res
    }

    operator fun hasNext(): Boolean {
        return node != null
    }
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */