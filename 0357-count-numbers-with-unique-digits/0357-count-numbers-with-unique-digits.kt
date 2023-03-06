class Solution {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        if (n == 0) return 1
        var temp = 9
        var res = 10
        for (i in 1 until n) {
            temp *= (10 - i)
            res += temp
        }
        return res
    }
}
