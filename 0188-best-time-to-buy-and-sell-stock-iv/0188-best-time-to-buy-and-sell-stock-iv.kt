class Solution {
    fun maxProfit(k: Int, prices: IntArray): Int {
        val n = prices.size
        val dp = IntArray(k + 1)
        val maxdp = IntArray(k + 1)
        for (i in 0..k) {
            maxdp[i] = Int.MIN_VALUE
        }
        for (i in 1..n) {
            maxdp[0] = Math.max(maxdp[0], dp[0] - prices[i - 1])
            for (j in k downTo 1) {
                maxdp[j] = Math.max(maxdp[j], dp[j] - prices[i - 1])
                dp[j] = Math.max(maxdp[j - 1] + prices[i - 1], dp[j])
            }
        }
        return dp[k]
    }
}
