class Solution {
    fun calculate(s: String): Int {
        var sum = 0
        var tempSum = 0
        var num = 0
        var lastSign = '+'
        for (i in 0 until s.length) {
            val c = s[i]
            if (Character.isDigit(c)) {
                num = num * 10 + c.toInt() - '0'.toInt()
            }
            if (i == s.length - 1 || !Character.isDigit(c) && c != ' ') {
                when (lastSign) {
                    '+' -> {
                        sum += tempSum
                        tempSum = num
                    }
                    '-' -> {
                        sum += tempSum
                        tempSum = -num
                    }
                    '*' -> tempSum *= num
                    '/' -> if (num != 0) {
                        tempSum /= num
                    }
                }
                lastSign = c
                num = 0
            }
        }
        sum += tempSum
        return sum
    }
}
