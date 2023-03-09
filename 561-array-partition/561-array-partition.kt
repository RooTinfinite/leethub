class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        var i = 0
        while (i < nums.size - 1) {
            sum += Math.min(nums[i], nums[i + 1])
            i = i + 2
        }
        return sum
    }
}
