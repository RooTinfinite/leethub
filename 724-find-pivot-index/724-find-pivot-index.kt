class Solution {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return -1
        }
        val sums = IntArray(nums.size)
        sums[0] = nums[0]
        for (i in 1 until nums.size) {
            sums[i] = sums[i - 1] + nums[i]
        }
        for (i in nums.indices) {
            val temp = sums[nums.size - 1] - sums[i]
            if (i == 0 && 0 == temp || i > 0 && sums[i - 1] == temp) {
                return i
            }
        }
        return -1
    }
}
