class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var sum = 0
        var curr = 0
        for (i in 2 until nums.size) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr++
                sum += curr
            } else {
                curr = 0
            }
        }
        return sum
    }
}
