class Solution {
    fun findNumberOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        val count = IntArray(nums.size)
        dp[0] = 1
        count[0] = 1
        var result = 0
        var max = Int.MIN_VALUE
        for (i in 1 until nums.size) {
            dp[i] = 1
            count[i] = 1
            for (j in i - 1 downTo 0) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1
                        count[i] = count[j]
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j]
                    }
                }
            }
        }
        for (i in nums.indices) {
            if (max < dp[i]) {
                result = count[i]
                max = dp[i]
            } else if (max == dp[i]) {
                result += count[i]
            }
        }
        return result
    }
}
