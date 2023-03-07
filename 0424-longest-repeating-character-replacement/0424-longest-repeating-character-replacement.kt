class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var right = 0
        val len = s.length
        val count = IntArray(256)
        val sArr = s.toCharArray()
        var currMax = 0
        var maxLen = 0
        var curr: Char
        while (right < len) {
            curr = sArr[right]
            count[curr.toInt()]++
            currMax = Math.max(currMax, count[curr.toInt()])
            if (right - left + 1 <= currMax + k) {
                maxLen = Math.max(maxLen, right - left + 1)
            }
            while (right - left + 1 > currMax + k) {
                curr = sArr[left]
                count[curr.toInt()]--
                left++
            }
            right++
        }
        return maxLen
    }
}
