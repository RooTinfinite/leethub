class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val dp = IntArray(cost.size)
        dp[0] = cost[0]
        dp[1] = cost[1]
        for (i in 2 until cost.size) {
            dp[i] = cost[i] + dp[i - 1].coerceAtMost(dp[i - 2])
        }
        return dp[cost.size - 1].coerceAtMost(dp[cost.size - 2])
    }
}
