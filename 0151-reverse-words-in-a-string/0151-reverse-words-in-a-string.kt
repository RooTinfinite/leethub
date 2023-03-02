class Solution {
    fun reverseWords(s: String): String {
        val sb = StringBuilder()
        var i = s.length - 1
        while (i >= 0) {
            if (s[i] == ' ') {
                i--
                continue
            }
            val start = s.lastIndexOf(' ', i)
            sb.append(' ')
            sb.append(s, start + 1, i + 1)
            i = start - 1
        }
        if (sb.length > 0) {
            sb.deleteCharAt(0)
        }
        return sb.toString()
    }
}
