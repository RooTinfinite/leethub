class Solution {
    fun checkPerfectNumber(num: Int): Boolean {
        var s = 1
        for (sq in Math.sqrt(num.toDouble()).toInt() downTo 2) {
            if (num % sq == 0) {
                s += sq + num / sq
            }
        }
        return num != 1 && s == num
    }
}
