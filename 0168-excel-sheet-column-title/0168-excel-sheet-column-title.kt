class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var num = columnNumber
        val sb = StringBuilder()
        while (num != 0) {
            var remainder = num % 26
            if (remainder == 0) {
                remainder += 26
            }
            if (num >= remainder) {
                num -= remainder
                sb.append((remainder + 64).toChar())
            }
            num /= 26
        }
        return sb.reverse().toString()
    }
}
