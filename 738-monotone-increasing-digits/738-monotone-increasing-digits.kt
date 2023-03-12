class Solution {
    fun monotoneIncreasingDigits(n: Int): Int {
        var n = n
        var i = 10
        while (n / i > 0) {
            val digit = n / i % 10
            val endNum = n % i
            val firstEndNum = endNum * 10 / i
            if (digit > firstEndNum) {
                n -= endNum + 1
            }
            i *= 10
        }
        return n
    }
}
