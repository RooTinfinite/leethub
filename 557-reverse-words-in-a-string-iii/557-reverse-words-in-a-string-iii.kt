class Solution {
    fun reverseWords(s: String): String {
        var l: Int
        var r = 0
        val len = s.length
        val ch = s.toCharArray()
        for (i in 0..len) {
            if (i == len || ch[i] == ' ') {
                l = r
                r = i
                reverse(ch, l, r - 1)
                r++
            }
        }
        return String(ch)
    }

    private fun reverse(s: CharArray, l: Int, r: Int) {
        var l = l
        var r = r
        var c: Char
        while (r > l) {
            c = s[l]
            s[l++] = s[r]
            s[r--] = c
        }
    }
}
