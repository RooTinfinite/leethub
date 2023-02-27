class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var nextMax = nums[0]
        var curMax = nums[0]
        for (i in 1 until nums.size) {
            nextMax += nums[i]
            if (nextMax < nums[i]) {
                nextMax = nums[i]
            }
            if (nextMax > curMax) {
                curMax = nextMax
            }
        }
        return curMax
    }
}
