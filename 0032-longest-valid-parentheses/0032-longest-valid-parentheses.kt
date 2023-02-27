class Solution {
    fun longestValidParentheses(s: String): Int {
        var max = 0
        var left = 0
        var right = 0
        val n = s.length
        var ch: Char
        for (i in 0 until n) {
            ch = s[i]
            if (ch == '(') {
                left++
            } else {
                right++
            }
            if (right > left) {
                left = 0
                right = 0
            }
            if (left == right) {
                max = Math.max(max, left + right)
            }
        }
        left = 0
        right = 0
        for (i in n - 1 downTo 0) {
            ch = s[i]
            if (ch == '(') {
                left++
            } else {
                right++
            }
            if (left > right) {
                left = 0
                right = 0
            }
            if (left == right) {
                max = Math.max(max, left + right)
            }
        }
        return max
    }
}
