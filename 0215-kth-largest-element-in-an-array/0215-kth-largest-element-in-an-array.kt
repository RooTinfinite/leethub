class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val n = nums.size
        nums.sort()
        return nums[n - k]
    }
}
