class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        return n > 0 && Integer.bitCount(n) == 1
    }
}
