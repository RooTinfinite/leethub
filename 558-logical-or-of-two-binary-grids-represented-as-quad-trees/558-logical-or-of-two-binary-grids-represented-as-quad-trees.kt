/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */
class Solution {
    fun intersect(quadTree1: Node?, quadTree2: Node?): Node? {
        if (quadTree1!!.isLeaf) {
            return if (quadTree1.`val`) quadTree1 else quadTree2
        }
        if (quadTree2!!.isLeaf) {
            return if (quadTree2.`val`) quadTree2 else quadTree1
        }
        val out = Node(false, false)
        val tl: Node? = intersect(quadTree1.topLeft, quadTree2.topLeft)
        val tr: Node? = intersect(quadTree1.topRight, quadTree2.topRight)
        val bl: Node? = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
        val br: Node? = intersect(quadTree1.bottomRight, quadTree2.bottomRight)
        if ((
            tl!!.isLeaf &&
                tr!!.isLeaf &&
                bl!!.isLeaf &&
                br!!.isLeaf && tl.`val` == tr.`val`
            ) && tr.`val` == bl.`val` && br.`val` == bl.`val`
        ) {
            out.isLeaf = true
            out.`val` = tl.`val`
        } else {
            out.topLeft = tl
            out.topRight = tr
            out.bottomLeft = bl
            out.bottomRight = br
        }
        return out
    }
}
