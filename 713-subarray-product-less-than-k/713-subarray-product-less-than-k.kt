class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var p = 1
        var j = 0
        var ans = 0
        for (i in nums.indices) {
            p *= nums[i]
            while (p >= k && j < i) {
                p /= nums[j]
                j++
            }
            ans += if (p < k) i - j + 1 else 0
        }
        return ans
    }
}
