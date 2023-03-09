class Solution {
    /*
     * Since the incrementing starts from zero to op[0] and op[1], we only need to find the range that
     * has the most overlaps. Thus we keep finding the minimum of both x and y.
     */
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
        var x = m
        var y = n
        for (op in ops) {
            x = x.coerceAtMost(op[0])
            y = y.coerceAtMost(op[1])
        }
        return x * y
    }
}
