class Solution {
    fun toLowerCase(s: String): String {
        val c = s.toCharArray()
        for (i in s.indices) {
            if (c[i] in 'A'..'Z') {
                c[i] = (c[i].toInt() - 'A'.toInt() + 'a'.toInt()).toChar()
            }
        }
        return String(c)
    }
}
