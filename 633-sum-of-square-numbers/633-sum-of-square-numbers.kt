import kotlin.math.sqrt

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        val right = sqrt(c.toDouble()).toInt()
        val left = sqrt(c.toDouble() / 2).toInt()
        for (i in left..right) {
            val j = sqrt(c - (i * i).toDouble()).toInt()
            if (i * i + j * j == c) {
                return true
            }
        }
        return false
    }
}
