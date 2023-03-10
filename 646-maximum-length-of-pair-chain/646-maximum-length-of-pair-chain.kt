import java.util.Arrays

class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        if (pairs.size == 1) {
            return 1
        }
        Arrays.sort(pairs) { a: IntArray, b: IntArray ->
            a[1] - b[1]
        }
        var min = pairs[0][1]
        var max = 1
        for (i in 1 until pairs.size) {
            if (pairs[i][0] > min) {
                max++
                min = pairs[i][1]
            }
        }
        return max
    }
}
