class Solution {
    fun majorityElement(arr: IntArray): Int {
        var count = 1
        var majority = arr[0]
        // For Potential Majority Element
        for (i in 1 until arr.size) {
            if (arr[i] == majority) {
                count++
            } else {
                if (count > 1) {
                    count--
                } else {
                    majority = arr[i]
                }
            }
        }
        // For Confirmation
        count = 0
        for (j in arr) {
            if (j == majority) {
                count++
            }
        }
        return if (count >= arr.size / 2 + 1) {
            majority
        } else {
            -1
        }
    }
}
