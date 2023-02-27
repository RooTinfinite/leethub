class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var i = 0
        var j = 0
        var longest = 0
        // 1. if string empty, return 0
        if (s.isEmpty()) {
            return 0
        }
        while (j < s.length) {
            // 2. if the char at index j already seen, update the longest if needs
            if (i != j && s.substring(i, j).indexOf(s[j]) > -1) {
                longest = Math.max(j - i, longest)
                i++
            } else {
                // 3. j out of bound already, update longest
                if (++j == s.length) {
                    longest = Math.max(s.length - i, longest)
                    break
                }
            }
        }
        return longest
    }
}
