class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var product = 1
        val ans = IntArray(nums.size)
        for (num in nums) {
            product = product * num
        }
        for (i in nums.indices) {
            if (nums[i] != 0) {
                ans[i] = product / nums[i]
            } else {
                var p = 1
                for (j in nums.indices) {
                    if (j != i) {
                        p = p * nums[j]
                    }
                }
                ans[i] = p
            }
        }
        return ans
    }
}
