class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val hm: MutableMap<String, MutableList<String>> = HashMap()
        for (s in strs) {
            val ch = s.toCharArray()
            ch.sort()
            val temp = String(ch)
            hm.computeIfAbsent(
                temp
            ) { _: String? -> ArrayList() }
            hm[temp]!!.add(s)
        }
        return ArrayList<List<String>>(hm.values)
    }
}
