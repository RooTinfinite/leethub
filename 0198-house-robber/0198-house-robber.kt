class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        if (nums.size == 2) {
            return Math.max(nums[0], nums[1])
        }
        val profit = IntArray(nums.size)
        profit[0] = nums[0]
        profit[1] = Math.max(nums[1], nums[0])
        for (i in 2 until nums.size) {
            profit[i] = Math.max(profit[i - 1], nums[i] + profit[i - 2])
        }
        return profit[nums.size - 1]
    }
}
