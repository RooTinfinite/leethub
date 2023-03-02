class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var n = n
        var ret = 0
        // because there are 32 bits in total
        for (i in 0..31) {
            ret = ret shl 1
            // If the bit is 1 we OR it with 1, ie add 1
            if (n and 1 > 0) {
                ret = ret or 1
            }
            n = n ushr 1
        }
        return ret
    }
}
