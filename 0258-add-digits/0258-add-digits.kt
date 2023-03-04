class Solution {
    fun addDigits(num: Int): Int {
        if (num == 0) {
            return 0
        }
        return if (num % 9 == 0) {
            9
        } else num % 9
    }
}
