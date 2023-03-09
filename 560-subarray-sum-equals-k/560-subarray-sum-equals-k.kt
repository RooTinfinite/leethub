class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var tempSum = 0
        var ret = 0
        val sumCount: MutableMap<Int, Int?> = HashMap()
        sumCount[0] = 1
        for (i in nums) {
            tempSum += i
            if (sumCount.containsKey(tempSum - k)) {
                ret += sumCount[tempSum - k]!!
            }
            if (sumCount[tempSum] != null) {
                sumCount[tempSum] = sumCount[tempSum]!! + 1
            } else {
                sumCount[tempSum] = 1
            }
        }
        return ret
    }
}
