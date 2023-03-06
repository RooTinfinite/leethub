class Solution {
    fun lastRemaining(n: Int): Int {
        return if (n == 1) 1 else 2 * (n / 2 - lastRemaining(n / 2) + 1)
    }
}
