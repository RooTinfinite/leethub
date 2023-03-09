class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map: MutableMap<Int, Int> = HashMap()
        var sum = 0
        map[0] = -1
        for (i in nums.indices) {
            sum += nums[i]
            val remainder = sum % k
            if (map.containsKey(remainder)) {
                if (map[remainder]!! + 1 < i) {
                    return true
                }
            } else {
                map[remainder] = i
            }
        }
        return false
    }
}
