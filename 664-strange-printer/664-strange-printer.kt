class Solution {
    fun strangePrinter(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val dp = Array(s.length) { IntArray(s.length) }
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                if (i == j) {
                    dp[i][j] = 1
                } else if (s[i] == s[i + 1]) {
                    dp[i][j] = dp[i + 1][j]
                } else {
                    dp[i][j] = dp[i + 1][j] + 1
                    for (k in i + 1..j) {
                        if (s[k] == s[i]) {
                            dp[i][j] = dp[i][j].coerceAtMost(dp[i + 1][k - 1] + dp[k][j])
                        }
                    }
                }
            }
        }
        return dp[0][s.length - 1]
    }
}
