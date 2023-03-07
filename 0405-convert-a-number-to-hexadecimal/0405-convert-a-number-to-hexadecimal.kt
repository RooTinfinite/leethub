class Solution {
    fun toHex(num: Int): String {
        var num = num
        if (num == 0) {
            return "0"
        }
        val sb = StringBuilder()
        var x: Int
        while (num != 0) {
            x = num and 0xf
            if (x < 10) {
                sb.append(x)
            } else {
                sb.append((x + 87).toChar())
            }
            num = num ushr 4
        }
        return sb.reverse().toString()
    }
}
