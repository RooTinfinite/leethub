class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            // This is done because start and end might be big numbers, so it might exceed the
            // integer limit.
            val mid = start + (end - start) / 2
            if (nums[mid + 1] > nums[mid]) {
                start = mid + 1
            } else {
                end = mid
            }
        }
        return start
    }
}
