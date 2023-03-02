class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        val str = Integer.toBinaryString(n).filter { it == '1' }
        return str.length
    }
}
