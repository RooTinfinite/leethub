class Solution {
    fun detectCapitalUse(word: String): Boolean {
        if (word.isEmpty()) {
            return false
        }
        var upper = 0
        var lower = 0
        val n = word.length
        var firstUpper = Character.isUpperCase(word[0])
        for (i in 0 until n) {
            if (Character.isUpperCase(word[i])) {
                upper++
            } else if (Character.isLowerCase(word[i])) {
                lower++
            }
        }
        if (firstUpper && upper > 1) {
            firstUpper = false
        }
        return upper == n || lower == n || firstUpper
    }
}
