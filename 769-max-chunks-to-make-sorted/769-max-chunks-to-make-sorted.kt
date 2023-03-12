class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        var ans = 0
        var max = 0
        for (i in arr.indices) {
            max = max.coerceAtLeast(arr[i])
            if (max == i) {
                ans++
            }
        }
        return ans
    }
}
