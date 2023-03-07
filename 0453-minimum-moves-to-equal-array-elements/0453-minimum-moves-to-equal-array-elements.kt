class Solution {
    fun minMoves(nums: IntArray): Int {
        var min = nums[0]
        var sum = nums[0]
        // determining the total sum and smallest element of the input array
        for (i in 1..nums.size - 1) {
            sum += nums[i]
            min = Math.min(min, nums[i])
        }
        return sum - min * nums.size
    }
}
