class Solution {
    private fun findMinUtil(nums: IntArray, l: Int, r: Int): Int {
        if (l == r) {
            return nums[l]
        }
        val mid = (l + r) / 2
        if (mid == l && nums[mid] < nums[r]) {
            return nums[l]
        }
        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return nums[mid]
        }
        if (nums[mid] < nums[l]) {
            return findMinUtil(nums, l, mid - 1)
        } else if (nums[mid] > nums[r]) {
            return findMinUtil(nums, mid + 1, r)
        }
        return findMinUtil(nums, l, mid - 1)
    }

    fun findMin(nums: IntArray): Int {
        val l = 0
        val r = nums.size - 1
        return findMinUtil(nums, l, r)
    }
}
