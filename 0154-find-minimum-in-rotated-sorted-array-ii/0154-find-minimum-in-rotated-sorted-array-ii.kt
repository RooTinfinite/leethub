class Solution {
    fun findMin(nums: IntArray): Int {
        return if (nums.isEmpty()) {
            0
        } else find(0, nums.size - 1, nums)
    }

    private fun find(left: Int, right: Int, nums: IntArray): Int {
        if (left + 1 >= right) {
            return Math.min(nums[left], nums[right])
        }
        val mid = left + (right - left) / 2
        if (nums[left] == nums[right] && nums[left] == nums[mid]) {
            return Math.min(find(left, mid, nums), find(mid, right, nums))
        }
        return if (nums[left] >= nums[right]) {
            if (nums[mid] >= nums[left]) {
                find(mid, right, nums)
            } else {
                find(left, mid, nums)
            }
        } else {
            find(left, mid, nums)
        }
    }
}
