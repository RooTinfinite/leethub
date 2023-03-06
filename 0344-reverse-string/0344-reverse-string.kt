class Solution {
    fun reverseString(s: CharArray) {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            val tmp = s[left]
            s[left++] = s[right]
            s[right--] = tmp
        }
    }
}
