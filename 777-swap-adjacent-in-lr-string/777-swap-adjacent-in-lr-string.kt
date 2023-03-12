class Solution {
    fun canTransform(start: String, end: String): Boolean {
        var i1 = 0
        var i2 = 0
        val s1 = start.toCharArray()
        val s2 = end.toCharArray()
        while (i1 < s1.size && i2 < s2.size) {
            while (i1 < s1.size && s1[i1] == 'X') {
                i1++
            }
            while (i2 < s2.size && s2[i2] == 'X') {
                i2++
            }
            if (i1 == s1.size && i2 == s2.size) {
                return true
            }
            if (i1 == s1.size || i2 == s2.size) {
                return false
            }
            val c1 = s1[i1]
            val c2 = s2[i2]
            if (c1 != c2) {
                return false
            }
            if (c1 == 'L' && i1 < i2) {
                return false
            }
            if (c1 == 'R' && i1 > i2) {
                return false
            }
            i1++
            i2++
        }
        while (i1 < s1.size && start[i1] == 'X') {
            i1++
        }
        while (i2 < s2.size && end[i2] == 'X') {
            i2++
        }
        return i1 == s1.size && i2 == s2.size
    }
}
