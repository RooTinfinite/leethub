class Solution {
    fun dominantIndex(arr: IntArray): Int {
        if (arr.size == 1) {
            return 0
        }
        if (arr.isEmpty()) {
            return -1
        }
        var maxElement = Int.MIN_VALUE
        for (a in arr) {
            maxElement = maxElement.coerceAtLeast(a)
        }
        val index = findNum(maxElement, arr)
        for (i in arr.indices) {
            if (i == index) {
                continue
            }
            if (arr[i] * 2 > maxElement) {
                return -1
            }
        }
        return index
    }

    private fun findNum(target: Int, arr: IntArray): Int {
        for (i in arr.indices) {
            if (arr[i] == target) {
                return i
            }
        }
        return -1
    }
}
