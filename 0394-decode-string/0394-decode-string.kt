class Solution {
    private var i = 0

    fun decodeString(s: String): String {
        var count = 0
        val sb = StringBuilder()
        while (i < s.length) {
            val c = s[i]
            i++
            if (Character.isLetter(c)) {
                sb.append(c)
            } else if (Character.isDigit(c)) {
                count = count * 10 + Character.getNumericValue(c)
            } else if (c == ']') {
                break
            } else if (c == '[') {
                // sub problem
                val repeat = decodeString(s)
                while (count > 0) {
                    sb.append(repeat)
                    count--
                }
            }
        }
        return sb.toString()
    }
}
