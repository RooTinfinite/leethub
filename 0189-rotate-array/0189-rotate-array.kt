class Solution {
    private fun reverse(nums: IntArray, l: Int, r: Int) {
        var l = l
        var r = r
        while (l <= r) {
            val temp = nums[l]
            nums[l] = nums[r]
            nums[r] = temp
            l++
            r--
        }
    }

    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val t = n - k % n
        reverse(nums, 0, t - 1)
        reverse(nums, t, n - 1)
        reverse(nums, 0, n - 1)
    }
}
