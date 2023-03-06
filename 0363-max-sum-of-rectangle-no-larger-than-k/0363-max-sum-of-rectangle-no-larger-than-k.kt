class Solution {
    fun maxSumSubmatrix(matrix: Array<IntArray>, k: Int): Int {
        if (matrix.size == 0 || matrix[0].size == 0) {
            return 0
        }
        val row = matrix.size
        val col = matrix[0].size
        var res = Int.MIN_VALUE
        for (i in 0 until col) {
            val sum = IntArray(row)
            for (j in i until col) {
                for (r in 0 until row) {
                    sum[r] += matrix[r][j]
                }
                var curr = 0
                var max = sum[0]
                for (n in sum) {
                    curr = Math.max(n, curr + n)
                    max = Math.max(curr, max)
                    if (max == k) {
                        return max
                    }
                }
                if (max < k) {
                    res = Math.max(max, res)
                } else {
                    for (a in 0 until row) {
                        var currSum = 0
                        for (b in a until row) {
                            currSum += sum[b]
                            if (currSum <= k) {
                                res = Math.max(currSum, res)
                            }
                        }
                    }
                    if (res == k) {
                        return res
                    }
                }
            }
        }
        return res
    }
}
