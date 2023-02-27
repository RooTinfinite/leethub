class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val result: MutableList<IntArray> = mutableListOf()
        if (intervals.size <= 1) return intervals
        intervals.sortBy { it.first() }
        var currentRange = 1
        var begin = intervals[0][0]
        var end = intervals[0][1]
        while (currentRange < intervals.size) {
            if (intervals[currentRange][0] > end) {
                result.add(intArrayOf(begin,end))
                begin = intervals[currentRange][0]
                end = intervals[currentRange][1]
            } else if (intervals[currentRange][1] > end) {
                end = intervals[currentRange][1]
            }
            currentRange++
        }
        result.add(intArrayOf(begin,end))
        return result.toTypedArray()
    }
}