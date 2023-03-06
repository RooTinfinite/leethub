class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val a: MutableMap<Int, Int> = mutableMapOf()
        for (i in 0 until nums1.size) {
            a[nums1[i]] = a.getOrDefault(nums1[i], 0) + 1
        }
        var s = MutableList<Int>(0) { 0 }
        for (i in 0 until nums2.size) {
            if (a.getOrDefault(nums2[i], 0)> 0) {
                s.add(nums2[i])
                a[nums2[i]] = a[nums2[i]]!! - 1
            }
        }
        return s.toIntArray()
    }
}
