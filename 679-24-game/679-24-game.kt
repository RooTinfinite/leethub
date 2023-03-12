import kotlin.math.abs

class Solution {
    private fun backtrack(list: DoubleArray, n: Int): Boolean {
        if (n == 1) {
            return abs(list[0] - 24) < EPS
        }
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                val a = list[i]
                val b = list[j]
                list[j] = list[n - 1]
                list[i] = a + b
                if (backtrack(list, n - 1)) {
                    return true
                }
                list[i] = a - b
                if (backtrack(list, n - 1)) {
                    return true
                }
                list[i] = b - a
                if (backtrack(list, n - 1)) {
                    return true
                }
                list[i] = a * b
                if (backtrack(list, n - 1)) {
                    return true
                }
                if (Math.abs(b) > EPS) {
                    list[i] = a / b
                    if (backtrack(list, n - 1)) {
                        return true
                    }
                }
                if (Math.abs(a) > EPS) {
                    list[i] = b / a
                    if (backtrack(list, n - 1)) {
                        return true
                    }
                }
                list[i] = a
                list[j] = b
            }
        }
        return false
    }

    fun judgePoint24(nums: IntArray): Boolean {
        val a = Arrays.stream(nums).asDoubleStream().toArray()
        return backtrack(a, a.size)
    }

    companion object {
        private const val EPS = 1e-6
    }
}
