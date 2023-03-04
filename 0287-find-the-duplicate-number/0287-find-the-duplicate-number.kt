class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val arr = IntArray(nums.size + 1)
        for (num in nums) {
            arr[num] += 1
            if (arr[num] == 2) {
                return num
            }
        }
        return 0
    }
}
