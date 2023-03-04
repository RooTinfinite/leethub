class Solution {
    fun nthUglyNumber(n: Int): Int {
        val ugly = IntArray(n)
        var i2 = 0
        var i3 = 0
        var i5 = 0
        var ugly2 = 2
        var ugly3 = 3
        var ugly5 = 5
        var nextugly: Int
        ugly[0] = 1
        for (i in 1 until n) {
            nextugly = Math.min(Math.min(ugly2, ugly3), ugly5)
            ugly[i] = nextugly
            if (nextugly == ugly2) {
                i2++
                ugly2 = ugly[i2] * 2
            }
            if (nextugly == ugly3) {
                i3++
                ugly3 = ugly[i3] * 3
            }
            if (nextugly == ugly5) {
                i5++
                ugly5 = ugly[i5] * 5
            }
        }
        return ugly[n - 1]
    }
}
