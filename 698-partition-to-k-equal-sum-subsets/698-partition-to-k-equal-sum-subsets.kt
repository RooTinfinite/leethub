class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        val n = nums.size
        var sum = 0
        for (num in nums) {
            sum += num
        }
        if (sum % k != 0) {
            return false
        }
        // sum of each subset = sum / k
        sum /= k
        val dp = IntArray(1 shl n)
        dp.fill(-1)
        dp[0] = 0
        for (i in 0 until (1 shl n)) {
            if (dp[i] == -1) {
                continue
            }
            val rem = sum - dp[i] % sum
            for (j in 0 until n) {
                // bitmask
                val tmp = i or (1 shl j)
                // skip if the bit is already taken
                if (tmp != i) {
                    // num too big for current subset
                    if (nums[j] > rem) {
                        break
                    }
                    // cumulative sum
                    dp[tmp] = dp[i] + nums[j]
                }
            }
        }
        // true if total sum of all nums is the same
        return dp[(1 shl n) - 1] == k * sum
    }
}
