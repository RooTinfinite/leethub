class Solution {
    fun judgeCircle(moves: String): Boolean {
        val map = IntArray(26)
        for (c in moves.toCharArray()) {
            map[c.toInt() - 'A'.toInt()]++
        }
        return map['U'.toInt() - 'A'.toInt()] == map['D'.toInt() - 'A'.toInt()] &&
            map['L'.toInt() - 'A'.toInt()] == map['R'.toInt() - 'A'.toInt()]
    }
}
