class Solution {
    fun sortColors(nums: IntArray) {
        var zeroes = 0
        var ones = 0
        for (i in nums.indices) {
            if (nums[i] == 0) {
                nums[zeroes++] = 0
            } else if (nums[i] == 1) {
                ones++
            }
        }
        for (j in zeroes until zeroes + ones) {
            nums[j] = 1
        }
        for (k in zeroes + ones until nums.size) {
            nums[k] = 2
        }
    }
}
