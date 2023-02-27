class Solution {
    fun divide(dividend: Int, divisor: Int): Int {
        val isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0
        var ans: Long = 0
        var divide = Math.abs(dividend.toLong())
        val divisorAbs = Math.abs(divisor.toLong())
        while (divide >= divisorAbs) {
            var temp = divisorAbs
            var cnt: Long = 1
            while (divide >= temp) {
                divide -= temp
                ans += cnt
                cnt = cnt shl 1
                temp = temp shl 1
            }
        }
        if (isNegative) {
            ans = -ans
        }
        val intMin = -(1 shl 31)
        val intMax = (1 shl 31) - 1
        if (ans < intMin || ans > intMax) {
            ans = intMax.toLong()
        }
        return ans.toInt()
    }
}
