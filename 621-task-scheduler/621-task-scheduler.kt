class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n <= 0) {
            return tasks.size
        }
        val counters = IntArray(26)
        var maxCount = 0
        for (task in tasks) {
            val idx = task.toInt() - 'A'.toInt()
            counters[idx]++
            maxCount = Math.max(maxCount, counters[idx])
        }
        var maxNum = 0
        for (counter in counters) {
            if (counter == maxCount) {
                maxNum++
            }
        }
        return Math.max(tasks.size, (maxCount - 1) * (n + 1) + maxNum)
    }
}
