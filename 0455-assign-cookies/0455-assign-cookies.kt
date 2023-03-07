class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        var result = 0
        var i = 0
        var j = 0
        while (i < g.size && j < s.size) {
            if (s[j] >= g[i]) {
                result++
                i++
            }
            j++
        }
        return result
    }
}
