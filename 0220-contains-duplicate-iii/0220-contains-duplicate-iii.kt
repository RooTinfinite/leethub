class Solution {
    private fun getId(i: Long, w: Long): Long {
        return if (i < 0) (i + 1) / w - 1 else i / w
    }

    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        if (t < 0) {
            return false
        }
        val d: MutableMap<Long, Long> = HashMap()
        val w = t.toLong() + 1
        for (i in nums.indices) {
            val m = getId(nums[i].toLong(), w)
            if (d.containsKey(m)) {
                return true
            }
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d[m - 1]!!) < w) {
                return true
            }
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d[m + 1]!!) < w) {
                return true
            }
            d[m] = nums[i].toLong()
            if (i >= k) {
                d.remove(getId(nums[i - k].toLong(), w))
            }
        }
        return false
    }
}
