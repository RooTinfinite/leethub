class Solution {
    private var i = 0
    fun calculate(s: String): Int {
        val ca = s.toCharArray()
        return helper(ca)
    }

    private fun helper(ca: CharArray): Int {
        var num = 0
        var prenum = 0
        var isPlus = true
        while (i < ca.size) {
            val c = ca[i]
            if (c != ' ') {
                if (c >= '0' && c <= '9') {
                    num = if (num == 0) {
                        c.toInt() - '0'.toInt()
                    } else {
                        num * 10 + c.toInt() - '0'.toInt()
                    }
                } else if (c == '+') {
                    prenum += num * if (isPlus) 1 else -1
                    isPlus = true
                    num = 0
                } else if (c == '-') {
                    prenum += num * if (isPlus) 1 else -1
                    num = 0
                    isPlus = false
                } else if (c == '(') {
                    i++
                    prenum += helper(ca) * if (isPlus) 1 else -1
                    isPlus = true
                    num = 0
                } else if (c == ')') {
                    return prenum + num * if (isPlus) 1 else -1
                }
            }
            i++
        }
        return prenum + num * if (isPlus) 1 else -1
    }
}
