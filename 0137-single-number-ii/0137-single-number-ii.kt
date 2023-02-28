class Solution {
    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for (num in nums) {
            ones = ones xor num and twos.inv()
            twos = twos xor num and ones.inv()
        }
        return ones
    }
}
