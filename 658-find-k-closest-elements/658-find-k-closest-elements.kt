class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var left = 0
        var right = arr.size - k
        val answer: MutableList<Int> = ArrayList()
        while (left < right) {
            val mid = left + (right - left) / 2
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        for (i in left until left + k) {
            answer.add(arr[i])
        }
        return answer
    }
}
