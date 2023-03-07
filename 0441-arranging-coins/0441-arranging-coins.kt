class Solution {
    fun arrangeCoins(n: Int): Int {
        var i = 1
        var x = n
        while (x > 0) {
            x -= ++i
        }
        return i - 1
    }
}
