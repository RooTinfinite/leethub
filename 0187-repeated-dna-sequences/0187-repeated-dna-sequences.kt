class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) {
            return emptyList()
        }
        val seen = BooleanArray(1024 * 1024)
        val added = BooleanArray(1024 * 1024)
        val chars = s.toCharArray()
        var buf = 0
        val map = IntArray(128)
        map['A'.toInt()] = 0
        map['C'.toInt()] = 1
        map['G'.toInt()] = 2
        map['T'.toInt()] = 3
        val ans: MutableList<String> = ArrayList(s.length / 2)
        for (i in 0..9) {
            buf = (buf shl 2) + map[chars[i].toInt()]
        }
        seen[buf] = true
        for (i in 10 until chars.size) {
            buf = (buf shl 2 and 0xFFFFF) + map[chars[i].toInt()]
            if (seen[buf]) {
                if (!added[buf]) {
                    ans.add(String(chars, i - 9, 10))
                    added[buf] = true
                }
            } else {
                seen[buf] = true
            }
        }
        return ans
    }
}
