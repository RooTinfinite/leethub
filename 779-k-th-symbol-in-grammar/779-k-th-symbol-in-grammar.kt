class Solution {
    /*
     * Time: O(logn)
     * Space: O(1)
     */
    fun kthGrammar(n: Int, k: Int): Int {
        return Integer.bitCount(k - 1) % 2
    }
}
