class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (coin in coins) {
            for (i in coin..amount) {
                val prev = dp[i - coin]
                if (prev > 0) {
                    if (dp[i] == 0) {
                        dp[i] = prev + 1
                    } else {
                        dp[i] = Math.min(dp[i], prev + 1)
                    }
                }
            }
        }
        return dp[amount] - 1
    }
}
