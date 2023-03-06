class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        var count = 1
        val length = preorder.length
        for (i in 1..length) {
            if (i == length || preorder[i] == ',') {
                --count
                if (count < 0) {
                    return false
                }
                count += if (preorder[i - 1] == '#') 0 else 2
            }
        }
        return count == 0
    }
}
