class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var r = 0
        var c: Int = matrix[0].size - 1
        while (r < matrix.size && c >= 0) {
            if (matrix[r][c] == target) {
                return true
            } else if (matrix[r][c] > target) {
                c--
            } else {
                r++
            }
        }
        return false
    }
}
