class Solution {
    fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
        val n = nums.size
        val sums = LongArray(n + 1)
        for (i in 0 until n) {
            sums[i + 1] = sums[i] + nums[i]
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper)
    }

    private fun countWhileMergeSort(sums: LongArray, start: Int, end: Int, lower: Int, upper: Int): Int {
        if (end - start <= 1) {
            return 0
        }
        val mid = (start + end) / 2
        var count = (
            countWhileMergeSort(sums, start, mid, lower, upper) +
                countWhileMergeSort(sums, mid, end, lower, upper)
            )
        var j = mid
        var k = mid
        var t = mid
        val cache = LongArray(end - start)
        var r = 0
        for (i in start until mid) {
            while (k < end && sums[k] - sums[i] < lower) {
                k++
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j++
            }
            while (t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++]
            }
            cache[r] = sums[i]
            count += j - k
            r++
        }
        System.arraycopy(cache, 0, sums, start, t - start)
        return count
    }
}
