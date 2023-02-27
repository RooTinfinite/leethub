class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val endRow = matrix.size
        val endCol: Int = matrix[0].size
        var targetRow = 0
        var result = false
        for (i in 0 until endRow) {
            if (matrix[i][endCol - 1] >= target) {
                targetRow = i
                break
            }
        }
        for (i in 0 until endCol) {
            if (matrix[targetRow][i] == target) {
                result = true
                break
            }
        }
        return result
    }
}
