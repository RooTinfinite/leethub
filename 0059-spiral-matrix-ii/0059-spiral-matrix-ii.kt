class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        var num = 1
        var rStart = 0
        var rEnd = n - 1
        var cStart = 0
        var cEnd = n - 1
        val spiral = Array(n) { IntArray(n) }
        while (rStart <= rEnd && cStart <= cEnd) {
            for (k in cStart..cEnd) {
                spiral[rStart][k] = num++
            }
            rStart++
            for (k in rStart..rEnd) {
                spiral[k][cEnd] = num++
            }
            cEnd--
            if (rStart <= rEnd) {
                for (k in cEnd downTo cStart) {
                    spiral[rEnd][k] = num++
                }
            }
            rEnd--
            if (cStart <= cEnd) {
                for (k in rEnd downTo rStart) {
                    spiral[k][cStart] = num++
                }
            }
            cStart++
        }
        return spiral
    }
}
