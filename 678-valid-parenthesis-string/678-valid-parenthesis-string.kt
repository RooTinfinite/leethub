class Solution {
    fun checkValidString(s: String): Boolean {
        var lo = 0
        var hi = 0
        for (i in s.indices) {
            lo += if (s[i] == '(') 1 else -1
            hi += if (s[i] != ')') 1 else -1
            if (hi < 0) {
                break
            }
            lo = 0.coerceAtLeast(lo)
        }
        return lo == 0
    }
}
