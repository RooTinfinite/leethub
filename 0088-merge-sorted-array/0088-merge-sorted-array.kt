class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var i = m - 1
        var j = nums1.size - 1
        var p2 = n - 1
        while (p2 >= 0) {
            if (i >= 0 && nums1[i] > nums2[p2]) {
                nums1[j--] = nums1[i--]
            } else {
                nums1[j--] = nums2[p2--]
            }
        }
    }
}
