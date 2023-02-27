class Solution {
    fun jump(nums: IntArray): Int {
        var length = 0
        var maxLength = 0
        var minJump = 0
        for (i in 0 until nums.size - 1) {
            length--
            maxLength--
            maxLength = Math.max(maxLength, nums[i])
            if (length <= 0) {
                length = maxLength
                minJump++
            }
            if (length >= nums.size - i - 1) {
                return minJump
            }
        }
        return minJump
    }
}
