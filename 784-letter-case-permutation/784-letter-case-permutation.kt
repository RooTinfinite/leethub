class Solution {
    private val ans: MutableList<String> = ArrayList()
    fun letterCasePermutation(s: String): List<String> {
        helper(s, 0, "")
        return ans
    }

    private fun helper(s: String, curr: Int, temp: String) {
        if (curr == s.length) {
            ans.add(temp)
            return
        }
        if (Character.isDigit(s[curr])) {
            helper(s, curr + 1, temp + s[curr])
        } else {
            if (Character.isLowerCase(s[curr])) {
                helper(s, curr + 1, temp + s[curr])
                helper(s, curr + 1, temp + s.substring(curr, curr + 1).toUpperCase(Locale.getDefault()))
            } else {
                helper(s, curr + 1, temp + s[curr])
                helper(s, curr + 1, temp + s.substring(curr, curr + 1).toLowerCase(Locale.getDefault()))
            }
        }
    }
}
