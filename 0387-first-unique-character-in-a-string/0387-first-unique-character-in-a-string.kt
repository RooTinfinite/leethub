class Solution {
    fun firstUniqChar(s: String): Int {
        var ans = Int.MAX_VALUE
        var i = 'a'
        while (i <= 'z') {
            val ind = s.indexOf(i)
            if (ind != -1 && ind == s.lastIndexOf(i)) {
                ans = Math.min(ans, ind)
            }
            i++
        }
        return if (ans == Int.MAX_VALUE) {
            -1
        } else ans
    }
}
