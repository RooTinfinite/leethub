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
    fun construct(grid: Array<IntArray>): Node? {
        return construct(grid, 0, 0, grid.size)
    }

    private fun construct(grid: Array<IntArray>, x: Int, y: Int, len: Int): Node? {
        val value: Int = grid[x][y]
        if (len == 1) { return Node(value == 1, true) }
        var isLeaf = true
        for (i in 0 until len) {
            for (p in 0 until len) {
                if (grid[x + i][y + p] != value) {
                    isLeaf = false
                }
            }
        }
        if (isLeaf) { return Node(value == 1, true) }
        return Node(true, false).apply {
            val halfLength: Int = len / 2
            topLeft = construct(grid, x, y, halfLength)
            topRight = construct(grid, x, y + halfLength, halfLength)
            bottomLeft = construct(grid, x + halfLength, y, halfLength)
            bottomRight = construct(grid, x + halfLength, y + halfLength, halfLength)
        }
    }
}
