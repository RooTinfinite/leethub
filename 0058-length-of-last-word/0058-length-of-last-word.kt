class Solution {
    fun lengthOfLastWord(str: String): Int {
        var len = 0
        for (i in str.length - 1 downTo 0) {
            val ch = str[i]
            if (ch == ' ' && len > 0) {
                break
            } else if (ch != ' ') {
                len++
            }
        }
        return len
    }
}
