class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val map = IntArray(26)
        for (i in 0 until p.length) {
            map[p[i] - 'a']++
        }
        val res: MutableList<Int> = ArrayList()
        var i = 0
        var j = 0
        while (i < s.length) {
            val idx = s[i] - 'a'
            // add the new character
            map[idx]--
            // if the length is greater than windows length, pop the left charcater in the window
            if (i >= p.length) {
                map[s[j++] - 'a']++
            }
            var finish = true
            for (k in 0..25) {
                // if it is not an anagram of string p
                if (map[k] != 0) {
                    finish = false
                    break
                }
            }
            if (i >= p.length - 1 && finish) {
                res.add(j)
            }
            i++
        }
        return res
    }
}
