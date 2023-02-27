class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val n = s.length
        val m = p.length
        return solve(n - 1, m - 1, s, p)
    }

    private fun solve(i: Int, j: Int, s: String, p: String): Boolean {
        if (j < 0) {
            return i < 0
        }
        if (i < 0) {
            return p[j] == '*' && solve(i, j - 2, s, p)
        }
        // simple char matching
        // if s char matchs with p char or it can be '.'
        if (s[i] == p[j] || p[j] == '.') {
            return solve(i - 1, j - 1, s, p)
        }
        return if (p[j] == '*') {
            // if s char matches with p char or it can be '.'
            if (s[i] == p[j - 1] || p[j - 1] == '.') {
                solve(i - 1, j, s, p) || solve(i, j - 2, s, p)
            } else {
                solve(
                    i,
                    j - 2,
                    s,
                    p
                )
            }
        } else {
            false
        }
    }
}
