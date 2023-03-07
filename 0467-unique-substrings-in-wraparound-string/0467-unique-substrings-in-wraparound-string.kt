class Solution {
    fun findSubstringInWraproundString(p: String): Int {
        val str = p.toCharArray()
        val n = str.size
        val map = IntArray(26)
        var len = 0
        for (i in 0 until n) {
            if (i > 0 && (str[i - 1].toInt() + 1 == str[i].toInt() || str[i - 1] == 'z' && str[i] == 'a')) {
                len += 1
            } else {
                len = 1
            }
            // we are storing the max len of string for each letter and then we will count all these
            // length.
            map[str[i].toInt() - 'a'.toInt()] = Math.max(map[str[i].toInt() - 'a'.toInt()], len)
        }
        var answer = 0
        for (num in map) {
            answer += num
        }
        return answer
    }
}
