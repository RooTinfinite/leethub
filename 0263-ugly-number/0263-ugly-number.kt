class Solution {
    fun isUgly(n: Int): Boolean {
        if (n < 1) {
            return false
        }
        if (n == 1) {
            return true
        }
        var num = n
        for (divider in arrayOf(2, 3, 5)) {
            while (num % divider == 0) {
                num /= divider
            }
        }
        return num == 1
    }
}
