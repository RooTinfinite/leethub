class Solution {
    fun addBinary(a: String, b: String): String {
        val aArray = a.toCharArray()
        val bArray = b.toCharArray()
        val sb = StringBuilder()
        var i = aArray.size - 1
        var j = bArray.size - 1
        var carry = 0
        while (i >= 0 || j >= 0) {
            val sum = (if (i >= 0) aArray[i] - '0' else 0) + (if (j >= 0) bArray[j] - '0' else 0) + carry
            sb.append(sum % 2)
            carry = sum / 2
            if (i >= 0) {
                i--
            }
            if (j >= 0) {
                j--
            }
        }
        if (carry != 0) {
            sb.append(carry)
        }
        return sb.reverse().toString()
    }
}
