class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map: MutableMap<Int, Int> = HashMap()
        val len = nums.size
        for (i in 0 until len) {
            val index = map.put(nums[i], i)
            if (index != null && Math.abs(index - i) <= k) {
                return true
            }
        }
        return false
    }
}
