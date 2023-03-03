class Solution {
    fun countPrimes(n: Int): Int {
        val isprime = BooleanArray(n)
        var count = 0
        run {
            var i = 2
            while (i * i <= n) {
                if (!isprime[i]) {
                    var j = i * 2
                    while (j < n) {
                        isprime[j] = true
                        j += i
                    }
                }
                i++
            }
        }
        for (i in 2 until isprime.size) {
            if (!isprime[i]) {
                count++
            }
        }
        return count
    }
}
