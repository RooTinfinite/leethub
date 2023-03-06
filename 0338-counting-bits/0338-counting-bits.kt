class Solution {
    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        var borderPos = 1
        var incrPos = 1
        for (i in 1 until result.size) {
            // when we reach pow of 2, reset borderPos and incrPos
            if (incrPos == borderPos) {
                result[i] = 1
                incrPos = 1
                borderPos = i
            } else {
                result[i] = 1 + result[incrPos++]
            }
        }
        return result
    }
}
