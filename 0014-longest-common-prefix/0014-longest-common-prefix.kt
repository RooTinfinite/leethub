class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        var temp = strs[0]
        var i = 1
        var cur: String
        while (temp.length > 0 && i < strs.size) {
            if (temp.length > strs[i].length) {
                temp = temp.substring(0, strs[i].length)
            }
            cur = strs[i].substring(0, temp.length)
            if (cur != temp) {
                temp = temp.substring(0, temp.length - 1)
            } else {
                i++
            }
        }
        return temp
    }
}
