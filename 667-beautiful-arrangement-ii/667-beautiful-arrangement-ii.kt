class Solution {
    fun constructArray(n: Int, k: Int): IntArray {
        var k = k
        val res = IntArray(n)
        var left = 1
        var right = n
        for (i in 0 until n) {
            res[i] = if (k % 2 == 0) left++ else right--
            if (k > 1) {
                k--
            }
        }
        return res
    }
}
