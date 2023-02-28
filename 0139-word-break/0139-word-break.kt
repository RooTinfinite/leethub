class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val set: MutableSet<String> = HashSet()
        var max = 0
        val flag = BooleanArray(s.length + 1)
        for (st in wordDict) {
            set.add(st)
            if (max < st.length) {
                max = st.length
            }
        }
        for (i in 1..max) {
            if (dfs(s, 0, i, max, set, flag)) {
                return true
            }
        }
        return false
    }

    private fun dfs(s: String, start: Int, end: Int, max: Int, set: Set<String>, flag: BooleanArray): Boolean {
        if (!flag[end] && set.contains(s.substring(start, end))) {
            flag[end] = true
            if (end == s.length) {
                return true
            }
            for (i in 1..max) {
                if (end + i <= s.length && dfs(s, end, end + i, max, set, flag)) {
                    return true
                }
            }
        }
        return false
    }
}
