class Solution {
    private fun validSquare(n: Int): Boolean {
        val root = Math.sqrt(n.toDouble()).toInt()
        return root * root == n
    }

    fun numSquares(n: Int): Int {
        var n = n
        if (n < 4) {
            return n
        }
        if (validSquare(n)) {
            return 1
        }
        while (n and 3 == 0) {
            n = n shr 2
        }
        if (n and 7 == 7) {
            return 4
        }
        val x = Math.sqrt(n.toDouble()).toInt()
        for (i in 1..x) {
            if (validSquare(n - i * i)) {
                return 2
            }
        }
        return 3
    }
}
