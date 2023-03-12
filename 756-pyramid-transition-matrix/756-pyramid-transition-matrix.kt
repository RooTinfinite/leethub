class Solution {
    private fun dfs(c: CharArray, i: Int, l: Int, map: Array<IntArray>): Boolean {
        if (l == 1) {
            return true
        }
        if (i == l - 1) {
            return dfs(c, 0, l - 1, map)
        }
        val save = c[i]
        var p = 'A'
        var v = map[c[i].toInt() - 'A'.toInt()][c[i + 1].toInt() - 'A'.toInt()]
        while (v != 0) {
            if (v and 1 != 0) {
                c[i] = p
                if (dfs(c, i + 1, l, map)) {
                    return true
                }
            }
            v = v shr 1
            p++
        }
        c[i] = save
        return false
    }

    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val map = Array(7) { IntArray(7) }
        for (s in allowed) {
            map[s[0].toInt() - 'A'.toInt()][s[1].toInt() - 'A'.toInt()] =
                map[s[0].toInt() - 'A'.toInt()][s[1].toInt() - 'A'.toInt()] or (1 shl s[2].toInt() - 'A'.toInt())
        }
        return dfs(bottom.toCharArray(), 0, bottom.length, map)
    }
}
