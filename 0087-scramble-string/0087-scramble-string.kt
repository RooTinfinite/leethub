class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        val n = s1.length
        val dp = Array(n) { Array(n) { BooleanArray(n + 1) } }
        for (len in 1..n) {
            for (i in 0..n - len) {
                for (j in 0..n - len) {
                    if (len == 1) {
                        dp[i][j][len] = s1[i] == s2[j]
                    } else {
                        var k = 1
                        while (k < len && !dp[i][j][len]) {
                            dp[i][j][len] = (
                                dp[i][j][k] && dp[i + k][j + k][len - k] ||
                                    dp[i][j + len - k][k] && dp[i + k][j][len - k]
                                )
                            k++
                        }
                    }
                }
            }
        }
        return dp[0][0][n]
    }
}
