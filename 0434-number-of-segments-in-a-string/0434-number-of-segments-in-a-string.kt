class Solution {
    fun countSegments(s: String): Int {
        var s = s
        s = s.trim { it <= ' ' }
        if (s.length == 0) {
            return 0
        }
        val splitted = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var result = 0
        for (value in splitted) {
            if (value.length > 0) {
                result++
            }
        }
        return result
    }
}
