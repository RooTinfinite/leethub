class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val n = s1.length
        val m = s2.length
        if (n > m) {
            return false
        }
        val cntS1 = IntArray(26)
        val cntS2 = IntArray(26)
        for (i in 0 until n) {
            cntS1[s1[i].toInt() - 'a'.toInt()]++
        }
        for (i in 0 until n) {
            cntS2[s2[i].toInt() - 'a'.toInt()]++
        }
        if (check(cntS1, cntS2)) {
            return true
        }
        for (i in n until m) {
            cntS2[s2[i - n].toInt() - 'a'.toInt()]--
            cntS2[s2[i].toInt() - 'a'.toInt()]++
            if (check(cntS1, cntS2)) {
                return true
            }
        }
        return false
    }

    private fun check(cnt1: IntArray, cnt2: IntArray): Boolean {
        for (i in 0..25) {
            if (cnt1[i] != cnt2[i]) {
                return false
            }
        }
        return true
    }
}
