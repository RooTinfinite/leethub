class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }
        val m = haystack.length
        val n = needle.length
        for (start in 0 until m - n + 1) {
            if (haystack.substring(start, start + n) == needle) {
                return start
            }
        }
        return -1
    }
}
