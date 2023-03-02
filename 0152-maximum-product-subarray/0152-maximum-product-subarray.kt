class Solution {
    fun maxProduct(nums: IntArray): Int {
        var pos = nums[0]
        var neg = nums[0]
        var max = nums[0]
        for (i in 1 until nums.size) {
            val temp = pos
            pos = Math.max(nums[i], nums[i] * if (nums[i] >= 0) pos else neg)
            neg = Math.min(nums[i], nums[i] * if (nums[i] >= 0) neg else temp)
            max = Math.max(max, pos)
        }
        return max
    }
}
