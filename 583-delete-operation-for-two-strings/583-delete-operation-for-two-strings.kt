class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = if (word1[i - 1] == word2[j - 1]) dp[i - 1][j - 1] + 1 else Math.max(
                    dp[i - 1][j],
                    dp[i][j - 1]
                )
            }
        }
        return m + n - 2 * dp[m][n]
    }
}
