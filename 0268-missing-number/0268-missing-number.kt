class Solution {
    fun missingNumber(nums: IntArray): Int {
        var a = nums.size
        for (i in nums.indices) {
            a = a xor i
            a = a xor nums[i]
        }
        return a
    }
}
