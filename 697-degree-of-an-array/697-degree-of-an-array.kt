class Solution {
    private class Value(var count: Int, var start: Int, var end: Int)

    fun findShortestSubArray(nums: IntArray): Int {
        var max = 1
        val map: MutableMap<Int, Value> = HashMap()
        for (i in nums.indices) {
            val j = nums[i]
            if (map.containsKey(j)) {
                val v = map[j]
                v!!.count++
                max = Math.max(max, v.count)
                v.end = i
            } else {
                map[j] = Value(1, i, i)
            }
        }
        var min = Int.MAX_VALUE
        for (entry in map.entries.iterator()) {
            val v: Value = entry.value
            if (v.count == max) {
                min = min.coerceAtMost(v.end - v.start)
            }
        }
        return min + 1
    }
}
