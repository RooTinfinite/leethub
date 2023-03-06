class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val primes1 = LongArray(primes.size)
        for (i in primes.indices) {
            primes1[i] = primes[i].toLong()
        }
        val index = IntArray(primes.size)
        val n1 = LongArray(n)
        n1[0] = 1L
        for (i in 1 until n) {
            var min = Long.MAX_VALUE
            for (l in primes1) {
                min = Math.min(min, l)
            }
            n1[i] = min
            for (j in primes1.indices) {
                if (min == primes1[j]) {
                    primes1[j] = primes[j] * n1[++index[j]]
                }
            }
        }
        return n1[n - 1].toInt()
    }
}
