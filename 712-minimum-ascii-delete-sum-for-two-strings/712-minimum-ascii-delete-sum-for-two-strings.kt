class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val len1 = s1.length
        val len2 = s2.length
        val dp = Array(len1 + 1) { IntArray(len2 + 1) }
        var c1: Char
        var c2: Char
        for (i in 1 until len1 + 1) {
            dp[i][0] = dp[i - 1][0] + s1[i - 1].toInt()
        }
        for (j in 1 until len2 + 1) {
            dp[0][j] = dp[0][j - 1] + s2[j - 1].toInt()
        }
        for (i in 1 until len1 + 1) {
            c1 = s1[i - 1]
            for (j in 1 until len2 + 1) {
                c2 = s2[j - 1]
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = (dp[i - 1][j] + c1.toInt()).coerceAtMost(dp[i][j - 1] + c2.toInt())
                }
            }
        }
        return dp[len1][len2]
    }
}
