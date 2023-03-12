class Solution {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val m = nums1.size
        val n = nums2.size
        var max = 0
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]
                    max = Math.max(max, dp[i][j])
                }
            }
        }
        return max
    }
}
