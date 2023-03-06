class Solution {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        java.util.Arrays.sort(envelopes) { a, b -> if (a.get(0) !== b.get(0)) a.get(0) - b.get(0) else b.get(1) - a.get(1) }
        val tails = IntArray(envelopes.size)
        var size = 0
        for (enve in envelopes) {
            var i = 0
            var j = size
            while (i != j) {
                val mid = i + (j - i shr 1)
                if (tails[mid] < enve[1]) {
                    i = mid + 1
                } else {
                    j = mid
                }
            }
            tails[i] = enve[1]
            if (i == size) {
                size++
            }
        }
        return size
    }
}
