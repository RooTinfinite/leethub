class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n: Int = matrix.size
        for (i in 0 until n / 2) {
            for (j in i until n - i - 1) {
                val pos = arrayOf(
                    intArrayOf(i, j),
                    intArrayOf(j, n - 1 - i),
                    intArrayOf(n - 1 - i, n - 1 - j),
                    intArrayOf(n - 1 - j, i)
                )
                var t = matrix[pos[0][0]][pos[0][1]]
                for (k in 1 until pos.size) {
                    val temp = matrix[pos[k][0]][pos[k][1]]
                    matrix[pos[k][0]][pos[k][1]] = t
                    t = temp
                }
                matrix[pos[0][0]][pos[0][1]] = t
            }
        }
    }
}
