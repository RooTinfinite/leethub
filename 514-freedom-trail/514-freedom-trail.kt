class Solution {
    fun findRotateSteps(ring: String, key: String): Int {
        val indexs: Array<MutableList<Int>?> = arrayOfNulls<MutableList<Int>?>(26)
        for (i in 0 until ring.length) {
            val num = ring[i].toInt() - 'a'.toInt()
            if (indexs[num] == null) {
                indexs[num] = ArrayList()
            }
            indexs[num]!!.add(i)
        }
        val dp = Array(101) { IntArray(101) }
        return find(ring, 0, key, 0, dp, indexs)
    }

    private fun find(
        ring: String,
        i: Int,
        key: String,
        j: Int,
        cache: Array<IntArray>,
        indexs: Array<MutableList<Int>?>
    ): Int {
        if (j == key.length) {
            return 0
        }
        if (cache[i][j] != 0) {
            return cache[i][j]
        }
        var ans = Int.MAX_VALUE
        val targets: List<Int>? = indexs[key[j].toInt() - 'a'.toInt()]
        for (t in targets!!) {
            var delta = Math.abs(i - t)
            delta = Math.min(delta, Math.abs(ring.length - delta))
            ans = Math.min(ans, 1 + delta + find(ring, t, key, j + 1, cache, indexs))
        }
        cache[i][j] = ans
        return ans
    }
}
