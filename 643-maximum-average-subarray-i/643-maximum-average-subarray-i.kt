class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var windowSum = 0.0
        var windowStart = 0
        var max = Int.MIN_VALUE.toDouble()
        for (windowEnd in nums.indices) {
            windowSum += nums[windowEnd].toDouble()
            if (windowEnd >= k - 1) {
                val candidate = windowSum / k
                max = Math.max(candidate, max)
                windowSum -= nums[windowStart].toDouble()
                windowStart++
            }
        }
        return max
    }
}
