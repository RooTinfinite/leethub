class Solution {
    fun reverseStr(s: String, k: Int): String {
        val res = StringBuilder()
        var p1 = 0
        var p2 = 2 * k - 1
        if (s.length < k) {
            res.append(reverse(s))
            return res.toString()
        }
        while (p1 < s.length) {
            if (s.length < p1 + k) {
                res.append(reverse(s.substring(p1)))
            } else {
                res.append(reverse(s.substring(p1, p1 + k)))
                if (s.length < p2 + 1) {
                    res.append(s.substring(p1 + k))
                } else {
                    res.append(s, p1 + k, p2 + 1)
                }
            }
            p1 = p1 + 2 * k
            p2 = p2 + 2 * k
        }
        return res.toString()
    }

    private fun reverse(s: String): String {
        val sb = StringBuilder()
        sb.append(s)
        sb.reverse()
        return sb.toString()
    }
}
