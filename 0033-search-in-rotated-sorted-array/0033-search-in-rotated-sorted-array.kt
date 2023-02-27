class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var mid: Int
        var lo = 0
        var hi = nums.size - 1
        while (lo <= hi) {
            mid = (hi - lo shr 1) + lo
            if (target == nums[mid]) {
                return mid
            }
            // if this is true, then the possible rotation can only be in the second half
            if (nums[lo] <= nums[mid]) {
                // the target is in the first half only if it's
                if (nums[lo] <= target && target <= nums[mid]) {
                    // included
                    hi = mid - 1
                } else {
                    // between nums[lo] and nums[mid]
                    lo = mid + 1
                }
                // otherwise, the possible rotation can only be in the first half
            } else if (nums[mid] <= target && target <= nums[hi]) {
                // the target is in the second half only if it's included
                lo = mid + 1
            } else {
                // between nums[hi] and nums[mid]
                hi = mid - 1
            }
        }
        return -1
    }
}
