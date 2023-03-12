class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        val n = nums.size
        if (n <= 2) {
            return true
        }

        var isModified = false
        for (i in 0..(n - 2)) {
            if (nums[i] <= nums[i + 1]) {
                continue
            }
            if (isModified) {
                return false
            }

            when {
                i == 0 || nums[i - 1] <= nums[i + 1] -> {
                    nums[i] = nums[i + 1]
                    isModified = true
                }
                i == n - 2 || nums[i] <= nums[i + 2] -> {
                    nums[i + 1] = nums[i]
                    isModified = true
                }
                else -> {
                    return false
                }
            }
        }
        return true
    }
}
