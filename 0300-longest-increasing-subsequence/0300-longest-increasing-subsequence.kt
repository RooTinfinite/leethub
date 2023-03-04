class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val dp = IntArray(nums.size + 1)
        // prefill the dp table
        for (i in 1 until dp.size) {
            dp[i] = Int.MAX_VALUE
        }
        val left = 1
        var right = 1
        for (curr in nums) {
            var start = left
            var end = right
            // binary search, find the one that is lower than curr
            while (start + 1 < end) {
                val mid = start + (end - start) / 2
                if (dp[mid] > curr) {
                    end = mid
                } else {
                    start = mid
                }
            }
            // update our dp table
            if (dp[start] > curr) {
                dp[start] = curr
            } else if (curr > dp[start] && curr < dp[end]) {
                dp[end] = curr
            } else if (curr > dp[end]) {
                dp[++end] = curr
                right++
            }
        }
        return right
    }
}
