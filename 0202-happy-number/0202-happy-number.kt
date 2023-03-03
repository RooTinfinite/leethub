class Solution {
    private val set = mutableSetOf<Int>()

    tailrec fun isHappy(n: Int): Boolean {
        var num = n
        var squareSum = 0
        while (num > 0) {
            val digit = num % 10
            squareSum += digit * digit
            num /= 10
        }
        if (squareSum == 1) {
            return true
        }
        if (set.contains(squareSum)) {
            return false
        }
        set.add(squareSum)
        return isHappy(squareSum)
    }
}
