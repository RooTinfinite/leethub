class Solution {
    fun findLUSlength(a: String, b: String): Int {
        return if (a == b) {
            -1
        } else a.length.coerceAtLeast(b.length)
    }
}
