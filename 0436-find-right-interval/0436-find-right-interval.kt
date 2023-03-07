import java.util.function.Function

class Solution {
    private fun findminmax(num: Array<IntArray>): IntArray {
        var min = num[0][0]
        var max = num[0][0]
        for (i in 1 until num.size) {
            min = Math.min(min, num[i][0])
            max = Math.max(max, num[i][0])
        }
        return intArrayOf(min, max)
    }

    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        if (intervals.size <= 1) {
            return intArrayOf(-1)
        }
        val n = intervals.size
        val result = IntArray(n)
        val map: MutableMap<Int, Int?> = HashMap()
        for (i in 0 until n) {
            map[intervals[i][0]] = i
        }
        val minmax = findminmax(intervals)
        for (i in minmax[1] - 1 downTo minmax[0] + 1) {
            map.computeIfAbsent(i, Function { k: Int -> map[k + 1] })
        }
        for (i in 0 until n) {
            result[i] = map.getOrDefault(intervals[i][1], -1)!!
        }
        return result
    }
}
