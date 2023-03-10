class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val ans = IntArray(2)
        var i = 0
        while (i < nums.size) {
            val correct = nums[i] - 1
            if (nums[i] != nums[correct]) {
                val temp = nums[i]
                nums[i] = nums[correct]
                nums[correct] = temp
            } else {
                i++
            }
        }
        for (a in nums.indices) {
            if (nums[a] != a + 1) {
                ans[0] = nums[a]
                ans[1] = a + 1
                break
            }
        }
        return ans
    }
}
