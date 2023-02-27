class Solution constructor() {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val ans = IntArray(2)
        ans[0] = helper(nums, target, false)
        ans[1] = helper(nums, target, true)
        return ans
    }

    private fun helper(nums: IntArray, target: Int, equals: Boolean): Int {
        var l = 0
        var r: Int = nums.size - 1
        var result: Int = -1
        while (l <= r) {
            val mid: Int = l + (r - l) / 2
            if (nums[mid] == target) {
                result = mid
            }
            if (nums[mid] < target || (nums[mid] == target && equals)) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        }
        return result
    }
}
