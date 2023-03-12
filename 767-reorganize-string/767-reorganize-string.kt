class Solution {
    fun reorganizeString(s: String): String {
        val hash = IntArray(26)
        for (element in s) {
            hash[element.toInt() - 'a'.toInt()]++
        }
        var max = 0
        var letter = 0
        for (i in hash.indices) {
            if (hash[i] > max) {
                max = hash[i]
                letter = i
            }
        }
        if (max > (s.length + 1) / 2) {
            return ""
        }
        val res = CharArray(s.length)
        var idx = 0
        while (hash[letter] > 0) {
            res[idx] = (letter + 'a'.toInt()).toChar()
            idx += 2
            hash[letter]--
        }
        for (i in hash.indices) {
            while (hash[i] > 0) {
                if (idx >= res.size) {
                    idx = 1
                }
                res[idx] = (i + 'a'.toInt()).toChar()
                idx += 2
                hash[i]--
            }
        }
        return String(res)
    }
}
