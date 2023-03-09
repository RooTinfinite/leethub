class Solution {
    fun findMinMoves(machines: IntArray): Int {
        var total = 0
        for (i in machines) {
            total += i
        }
        if (total % machines.size != 0) {
            return -1
        }
        val avg = total / machines.size
        var cnt = 0
        var max = 0
        for (load in machines) {
            cnt += load - avg
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg)
        }
        return max
    }
}
