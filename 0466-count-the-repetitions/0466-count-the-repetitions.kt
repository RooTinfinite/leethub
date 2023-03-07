class Solution {
    fun getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int {
        val n = s2.length
        val ss1 = s1.toCharArray()
        val ss2 = s2.toCharArray()
        val memo = arrayOfNulls<IntArray>(n)
        val s2CountMap = IntArray(n + 1)
        var s1Count = 0
        var s2Count = 0
        var s2Idx = 0
        while (memo[s2Idx] == null) {
            memo[s2Idx] = intArrayOf(s1Count, s2Count)
            for (c1 in ss1) {
                if (c1 == ss2[s2Idx]) {
                    s2Idx++
                    if (s2Idx == n) {
                        s2Count++
                        s2Idx = 0
                    }
                }
            }
            s1Count++
            s2CountMap[s1Count] = s2Count
        }
        var n1Left = n1 - memo[s2Idx]!![0]
        val matchedPatternCount = n1Left / (s1Count - memo[s2Idx]!![0]) * (s2Count - memo[s2Idx]!![1])
        n1Left = n1Left % (s1Count - memo[s2Idx]!![0])
        val leftS2Count = s2CountMap[memo[s2Idx]!![0] + n1Left] - memo[s2Idx]!![1]
        val totalCount = leftS2Count + matchedPatternCount + memo[s2Idx]!![1]
        return totalCount / n2
    }
}
