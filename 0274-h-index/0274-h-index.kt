class Solution {
    fun hIndex(citations: IntArray): Int {
        val counts = IntArray(citations.size + 1)
        for (citation in citations) {
            val idx = (citations.size).coerceAtMost(citation)
            counts[idx] += 1
        }
        var total = 0
        for (i in counts.indices) {
            val idx = citations.size - i
            total += counts[idx]
            if (total >= idx) {
                return idx
            }
        }
        return 0
    }
}
