class Solution {
    fun arrayNesting(nums: IntArray): Int {
        var index: Int
        var value: Int
        var maxLen = 0
        var len: Int
        for (i in nums.indices) {
            if (nums[i] != -1) {
                index = i
                len = 0
                while (nums[index] != -1) {
                    value = nums[index]
                    nums[index] = -1
                    index = value
                    len++
                }
                maxLen = Math.max(len, maxLen)
            }
        }
        return maxLen
    }
}
