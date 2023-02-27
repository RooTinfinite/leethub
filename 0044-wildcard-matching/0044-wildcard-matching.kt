class Solution {
    fun isMatch(inputString: String, pattern: String): Boolean {
        var i = 0
        var j = 0
        var starIdx = -1
        var lastMatch = -1
        while (i < inputString.length) {
            if (j < pattern.length &&
                (inputString[i] == pattern[j] || pattern[j] == '?')
            ) {
                i++
                j++
            } else if (j < pattern.length && pattern[j] == '*') {
                starIdx = j
                lastMatch = i
                j++
            } else if (starIdx != -1) {
                // there is a no match and there was a previous star, we will reset the j to indx
                // after star_index
                // lastMatch will tell from which index we start comparing the string if we
                // encounter * in pattern
                j = starIdx + 1
                // we are saying we included more characters in * so we incremented the
                lastMatch++
                // index
                i = lastMatch
            } else {
                return false
            }
        }
        var isMatch = true
        while (j < pattern.length && pattern[j] == '*') {
            j++
        }
        if (i != inputString.length || j != pattern.length) {
            isMatch = false
        }
        return isMatch
    }
}
