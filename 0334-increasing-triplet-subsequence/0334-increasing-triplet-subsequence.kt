class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return false
        }
        var big: Int = nums.lastIndex
        var medium: Int? = null
        for (i in nums.lastIndex - 1 downTo 0) {
            if (nums[i] > nums[big]) {
                big = i
                continue
            } else if ((medium != null && nums[i] > nums[medium] && nums[i] < nums[big]) ||
                (medium == null && nums[i] < nums[big])
            ) {
                medium = i
                continue
            } else if (medium != null && nums[i] < nums[medium]) {
                return true
            }
        }
        return false
    }
}
