class Solution {
    fun numTrees(n: Int): Int {
        var result: Long = 1
        for (i in 0 until n) {
            result *= 2L * n - i
            result /= (i + 1).toLong()
        }
        result /= (n + 1).toLong()
        return result.toInt()
    }
}
