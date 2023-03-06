class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        var lt = 1
        var gt = 1
        for (i in 1 until nums.size) {
            if (nums[i - 1] < nums[i]) {
                lt = gt + 1
            } else if (nums[i - 1] > nums[i]) {
                gt = lt + 1
            }
        }
        return Math.max(lt, gt)
    }
}
