class Solution {
    fun findMaximumXOR(nums: IntArray): Int {
        var max = 0
        var mask = 0
        val set: MutableSet<Int> = HashSet()
        var maxNum = 0
        for (i in nums) {
            maxNum = Math.max(maxNum, i)
        }
        for (i in 31 - Integer.numberOfLeadingZeros(maxNum) downTo 0) {
            set.clear()
            val bit = 1 shl i
            mask = mask or bit
            val temp = max or bit
            for (prefix in nums) {
                if (set.contains(prefix and mask xor temp)) {
                    max = temp
                    break
                }
                set.add(prefix and mask)
            }
        }
        return max
    }
}
