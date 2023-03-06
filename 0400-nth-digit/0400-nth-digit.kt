class Solution {
    /*
    * 1. find the length of the number where the nth digit is from
    * 2. find the actual number where the nth digit is from
    * 3. find the nth digit and return
    */
    fun findNthDigit(n: Int): Int {
        var n = n
        var len = 1
        var count: Long = 9
        var start = 1
        while (n > len * count) {
            n -= (len * count).toInt()
            len += 1
            count *= 10
            start *= 10
        }
        start += (n - 1) / len
        val s = Integer.toString(start)
        return Character.getNumericValue(s[(n - 1) % len])
    }
}
