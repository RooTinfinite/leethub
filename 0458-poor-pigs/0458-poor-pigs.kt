class Solution {
    fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {
        var buckets = buckets
        if (buckets-- == 1) {
            return 0
        }
        val base = minutesToTest / minutesToDie + 1
        var count = 0
        while (buckets > 0) {
            buckets /= base
            count++
        }
        return count
    }
}
