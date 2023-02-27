class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val num = 1
        var carry = 0
        var sum: Int
        for (i in digits.indices.reversed()) {
            sum = if (i == digits.size - 1) {
                digits[i] + carry + num
            } else {
                digits[i] + carry
            }
            carry = sum / 10
            digits[i] = sum % 10
        }
        if (carry != 0) {
            val ans = IntArray(digits.size + 1)
            ans[0] = carry
            System.arraycopy(digits, 0, ans, 1, ans.size - 1)
            return ans
        }
        return digits
    }
}
