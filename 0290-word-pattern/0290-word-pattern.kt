class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map: MutableMap<Char, String> = HashMap()
        val words = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (words.size != pattern.length) {
            return false
        }
        for (i in 0 until pattern.length) {
            if (!map.containsKey(pattern[i])) {
                if (map.containsValue(words[i])) {
                    return false
                }
                map[pattern[i]] = words[i]
            } else {
                if (words[i] != map[pattern[i]]) {
                    return false
                }
            }
        }
        return true
    }
}
