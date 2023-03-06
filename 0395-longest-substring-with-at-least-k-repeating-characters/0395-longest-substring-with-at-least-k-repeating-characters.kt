class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        return helper(s, k, 0, s.length)
    }

    private fun helper(s: String, k: Int, start: Int, end: Int): Int {
        if (end - start < k) {
            return 0
        }
        val nums = IntArray(26)
        for (i in start until end) {
            nums[s[i].toInt() - 'a'.toInt()]++
        }
        for (i in start until end) {
            if (nums[s[i].toInt() - 'a'.toInt()] < k) {
                var j = i + 1
                while (j < s.length && nums[s[j].toInt() - 'a'.toInt()] < k) {
                    j++
                }
                return Math.max(helper(s, k, start, i), helper(s, k, j, end))
            }
        }
        return end - start
    }
}
