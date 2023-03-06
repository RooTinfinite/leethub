class Solution {
    fun bulbSwitch(n: Int): Int {
        return if (n < 2) {
            n
        } else Math.sqrt(n.toDouble()).toInt()
    }
}
