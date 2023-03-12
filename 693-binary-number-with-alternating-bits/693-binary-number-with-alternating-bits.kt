class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        var n = n
        var prev = -1
        while (n != 0) {
            val v = n and 1
            n = n shr 1
            if (prev == v) {
                return false
            }
            prev = v
        }
        return true
    }
}
