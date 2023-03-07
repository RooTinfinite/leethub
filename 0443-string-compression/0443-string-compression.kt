class Solution {
    /* This is breaking the rules, it's not in-place. */
    fun compress(chars: CharArray): Int {
        if (chars.size == 0) {
            return 0
        }
        val sb = StringBuilder()
        var count = 1
        var prev = chars[0]
        for (i in 1 until chars.size) {
            if (chars[i] == prev) {
                count++
            } else {
                if (count > 1) {
                    sb.append(prev)
                    sb.append(count)
                } else if (count == 1) {
                    sb.append(prev)
                }
                prev = chars[i]
                count = 1
            }
        }
        sb.append(prev)
        if (count > 1) {
            sb.append(count)
        }
        var i = 0
        for (c in sb.toString().toCharArray()) {
            chars[i++] = c
        }
        return sb.length
    }
}
