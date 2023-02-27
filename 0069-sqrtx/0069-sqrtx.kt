class Solution {
    fun mySqrt(x: Int): Int {
        var start = 1
        var end = x / 2
        var sqrt = start + (end - start) / 2
        if (x == 0) {
            return 0
        }
        while (start <= end) {
            if (sqrt == x / sqrt) {
                return sqrt
            } else if (sqrt > x / sqrt) {
                end = sqrt - 1
            } else if (sqrt < x / sqrt) {
                start = sqrt + 1
            }
            sqrt = start + (end - start) / 2
        }
        return if (sqrt > x / sqrt) {
            sqrt - 1
        } else {
            sqrt
        }
    }
}
