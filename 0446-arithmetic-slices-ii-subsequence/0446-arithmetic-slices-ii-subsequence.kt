class Solution {
    fun numberOfArithmeticSlices(arr: IntArray): Int {
        val indexes: MutableMap<Long, MutableList<Int>> = HashMap()
        val length = Array(arr.size) { IntArray(arr.size) }
        var count = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                val ix = indexes[arr[i] - (arr[j] - arr[i].toLong())] ?: continue
                for (k in ix) {
                    length[i][j] += length[k][i] + 1
                }
                count += length[i][j]
            }
            indexes.computeIfAbsent(
                arr[i].toLong()
            ) { _: Long? -> ArrayList() }.add(i)
        }
        return count
    }
}
