class Solution {
    fun flipLights(n: Int, m: Int): Int {
        return if (n == 1 && m > 0) {
            2
        } else if (n == 2 && m == 1) {
            3
        } else if (n > 2 && m == 1 || n == 2 && m > 1) {
            4
        } else if (n > 2 && m == 2) {
            7
        } else if (n > 2 && m > 2) {
            8
        } else {
            1
        }
    }
}
