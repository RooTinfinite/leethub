class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        var j = 1
        if (n <= 1) {
            return n
        }
        while (j <= n - 1) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j]
                i++
            }
            j++
        }
        return i + 1
    }
}
