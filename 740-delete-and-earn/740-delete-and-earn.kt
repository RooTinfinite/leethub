class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        val sum = IntArray(10001)
        var min = 10001
        var max = 0
        for (num in nums) {
            sum[num] += num
            min = num.coerceAtMost(min)
            max = num.coerceAtLeast(max)
        }
        val dp = IntArray(max + 1)
        dp[min] = sum[min]
        for (i in min + 1..max) {
            dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + sum[i])
        }
        return dp[max]
    }
}
