class Solution {
    fun singleNumber(nums: IntArray): Int {
        var num = 0
        for (x in nums) {
            num = num xor x
        }
        return num
    }
}
