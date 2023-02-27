class Solution {
    fun minDistance(w1: String, w2: String): Int {
        val n1 = w1.length
        val n2 = w2.length
        if (n2 > n1) {
            return minDistance(w2, w1)
        }
        val dp = IntArray(n2 + 1)
        for (j in 0..n2) {
            dp[j] = j
        }
        for (i in 1..n1) {
            var pre = dp[0]
            dp[0] = i
            for (j in 1..n2) {
                val tmp = dp[j]
                dp[j] = if (w1[i - 1] != w2[j - 1]) 1 + Math.min(pre, Math.min(dp[j], dp[j - 1])) else pre
                pre = tmp
            }
        }
        return dp[n2]
    }
}
