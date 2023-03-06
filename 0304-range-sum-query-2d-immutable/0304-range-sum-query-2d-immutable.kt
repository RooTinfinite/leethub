class NumMatrix(matrix: Array<IntArray>) {

    private val M = matrix.size
    private val N = if (M > 0) matrix[0].size else 0

    var array = Array<IntArray> (M + 1) { IntArray(N + 1) }

    init {
        for (i in 1..M) {
            for (j in 1..N) {
                array[i][j] = matrix[i - 1][j - 1] + array[i][j - 1] + array[i - 1][j] - array[i - 1][j - 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return array[row2 + 1][col2 + 1] - array[row2 + 1][col1] - array[row1][col2 + 1] + array[row1][col1]
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */