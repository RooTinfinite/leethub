class Solution {
    fun countPalindromicSubsequences(s: String): Int {
        val big = 1000000007
        val len = s.length
        if (len < 2) {
            return len
        }
        val dp = Array(len) { IntArray(len) }
        for (i in 0 until len) {
            val c = s[i]
            var deta = 1
            dp[i][i] = 1
            var l2 = -1
            for (j in i - 1 downTo 0) {
                if (s[j] == c) {
                    if (l2 < 0) {
                        l2 = j
                        deta = dp[j + 1][i - 1] + 1
                    } else {
                        deta = dp[j + 1][i - 1] - dp[j + 1][l2 - 1]
                    }
                    deta = deal(deta, big)
                }
                dp[j][i] = deal(dp[j][i - 1] + deta, big)
            }
        }
        return deal(dp[0][len - 1], big)
    }

    private fun deal(x: Int, big: Int): Int {
        var x = x
        x %= big
        if (x < 0) {
            x += big
        }
        return x
    }
}
