class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        var end = -2
        var max = Int.MIN_VALUE
        for (i in nums.indices) {
            max = Math.max(max, nums[i])
            if (nums[i] < max) {
                end = i
            }
        }
        var start = -1
        var min = Int.MAX_VALUE
        for (i in nums.indices.reversed()) {
            min = Math.min(min, nums[i])
            if (nums[i] > min) {
                start = i
            }
        }
        return end - start + 1
    }
}
