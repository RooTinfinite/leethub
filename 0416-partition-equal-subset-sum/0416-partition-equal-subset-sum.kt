class Solution {
    fun canPartition(nums: IntArray): Boolean {
        var sums = 0
        for (num in nums) {
            sums += num
        }
        if (sums % 2 == 1) {
            return false
        }
        sums /= 2
        val dp = BooleanArray(sums + 1)
        dp[0] = true
        for (num in nums) {
            for (sum in sums downTo num) {
                dp[sum] = dp[sum] || dp[sum - num]
            }
        }
        return dp[sums]
    }
}
