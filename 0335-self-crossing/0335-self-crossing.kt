class Solution {
    fun isSelfCrossing(x: IntArray): Boolean {
        if (x.size < 4) {
            return false
        }
        for (i in 3 until x.size) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true
            }
            if (i > 4 && x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3] &&
                x[i - 2] >= x[i - 4]
            ) {
                return true
            }
            if (i > 3 && x[i - 1] == x[i - 3] && x[i] >= x[i - 2] - x[i - 4]) {
                return true
            }
        }
        return false
    }
}
