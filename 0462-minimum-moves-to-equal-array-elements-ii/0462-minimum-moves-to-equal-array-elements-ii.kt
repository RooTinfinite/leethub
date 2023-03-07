class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val median = (nums.size - 1) / 2
        var ops = 0
        for (num in nums) {
            if (num != nums[median]) {
                ops += Math.abs(nums[median] - num)
            }
        }
        return ops
    }
}
