class Solution {
    private val memo = IntArray(31)
    fun fib(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (memo[n] != 0) {
            return memo[n]
        }
        memo[n] = fib(n - 1) + fib(n - 2)
        return memo[n]
    }
}
