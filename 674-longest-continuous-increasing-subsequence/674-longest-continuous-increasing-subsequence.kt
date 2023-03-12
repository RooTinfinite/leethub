class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var ans = 1
        var count = 1
        for (i in 0 until nums.size - 1) {
            if (nums[i] < nums[i + 1]) {
                count++
            } else {
                ans = max(count, ans)
                count = 1
            }
        }
        return max(ans, count)
    }

    private fun max(n1: Int, n2: Int): Int {
        return Math.max(n1, n2)
    }
}
