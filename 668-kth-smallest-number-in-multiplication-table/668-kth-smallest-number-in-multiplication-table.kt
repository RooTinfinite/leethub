class Solution {
    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        var lo = 1
        var hi = m * n
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            var col = n
            var row = 1
            var count = 0
            while (row <= m && col >= 1) {
                val `val` = row * col
                if (`val` > mid) {
                    col--
                } else {
                    count += col
                    row++
                }
            }
            if (count < k) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
