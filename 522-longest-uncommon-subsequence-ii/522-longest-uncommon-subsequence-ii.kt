class Solution {
    fun findLUSlength(strs: Array<String>): Int {
        var maxUncommonLen = -1
        for (indx1 in strs.indices) {
            var isCommon = false
            for (indx2 in strs.indices) {
                if (indx2 != indx1 && isSubSequence(strs[indx1], strs[indx2])) {
                    isCommon = true
                    break
                }
            }
            if (!isCommon) {
                maxUncommonLen = Math.max(maxUncommonLen, strs[indx1].length)
            }
        }
        return maxUncommonLen
    }

    private fun isSubSequence(str1: String, str2: String): Boolean {
        var indx1 = 0
        for (indx2 in 0 until str2.length) {
            if (str1[indx1] == str2[indx2]) {
                indx1++
            }
            if (indx1 == str1.length) {
                return true
            }
        }
        return indx1 == str1.length
    }
}
