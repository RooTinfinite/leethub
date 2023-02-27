class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') {
            return 0
        }
        val n = s.length
        val f = IntArray(n + 1)
        // Auxiliary
        f[0] = 1
        f[1] = 1
        for (i in 2..n) {
            // Calculate the independent number
            if (s[i - 1] != '0') {
                // As long as the current character is not 0, it means that the previous decoding
                // number can be inherited
                f[i] = f[i - 1]
            }
            // Calculate the number of combinations
            val twodigits = (s[i - 2] - '0') * 10 + (s[i - 1] - '0')
            if (twodigits >= 10 && twodigits <= 26) {
                f[i] += f[i - 2]
            }
        }
        return f[n]
    }
}
