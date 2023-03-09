class Solution {
    fun findIntegers(n: Int): Int {
        val f = IntArray(32)
        f[0] = 1
        f[1] = 2
        var ans = 0
        var preBit = 0
        for (i in 2..31) {
            f[i] = f[i - 1] + f[i - 2]
        }
        for (k in 31 downTo 0) {
            if (n and (1 shl k) != 0) {
                // if that bit is on
                ans += f[k]
                if (preBit != 0) {
                    return ans
                }
                preBit = 1
            } else {
                preBit = 0
            }
        }
        return ans + 1
    }
}
