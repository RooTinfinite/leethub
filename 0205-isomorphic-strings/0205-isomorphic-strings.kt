class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = IntArray(128)
        val str = s.toCharArray()
        val tar = t.toCharArray()
        val n = str.size
        for (i in 0 until n) {
            if (map[tar[i].toInt()] == 0) {
                if (search(map, str[i].toInt(), tar[i].toInt()) != -1) {
                    return false
                }
                map[tar[i].toInt()] = str[i].toInt()
            } else {
                if (map[tar[i].toInt()] != str[i].toInt()) {
                    return false
                }
            }
        }
        return true
    }

    private fun search(map: IntArray, tar: Int, skip: Int): Int {
        for (i in 0..127) {
            if (i == skip) {
                continue
            }
            if (map[i] != 0 && map[i] == tar) {
                return i
            }
        }
        return -1
    }
}
