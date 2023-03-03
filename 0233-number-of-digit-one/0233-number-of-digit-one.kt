class Solution {
    fun countDigitOne(n: Int): Int {
        var ans = 0
        var k = n
        var cum = 0
        var curr10 = 1
        while (k > 0) {
            val rem = k % 10
            val q = k / 10
            ans += if (rem == 0) {
                q * curr10
            } else if (rem == 1) {
                q * curr10 + cum + 1
            } else {
                (q + 1) * curr10
            }
            k = q
            cum += rem * curr10
            curr10 *= 10
        }
        return ans
    }
}
