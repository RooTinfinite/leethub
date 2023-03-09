class Solution {
    fun singleNonDuplicate(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (mid + 1 < nums.size && nums[mid] != nums[mid + 1] && mid - 1 >= 0 && nums[mid] != nums[mid - 1]) {
                return nums[mid]
            } else if (mid + 1 < nums.size && nums[mid] == nums[mid + 1] && mid % 2 == 0) {
                start = mid + 1
            } else if (mid - 1 >= 0 && nums[mid] == nums[mid - 1] && mid % 2 == 1) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return nums[start]
    }
}
