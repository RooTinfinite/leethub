import java.util.BitSet

class Solution {
    fun longestPalindrome(s: String): Int {
        val set = BitSet(60)
        for (c in s.toCharArray()) {
            set.flip(c.toInt() - 'A'.toInt())
        }
        return if (set.isEmpty()) {
            s.length
        } else s.length - set.cardinality() + 1
    }
}
