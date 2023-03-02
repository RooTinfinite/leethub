class Solution {
    fun trailingZeroes(n: Int): Int {
        var base = 5
        var count = 0
        while (n >= base) {
            count += n / base
            base = base * 5
        }
        return count
    }
}
