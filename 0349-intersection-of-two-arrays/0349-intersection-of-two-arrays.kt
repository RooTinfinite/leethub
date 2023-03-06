class Solution {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val occ = BooleanArray(1001)
        for (k in nums1) {
            occ[k] = true
        }
        val res: MutableList<Int> = ArrayList()
        for (j in nums2) {
            if (occ[j]) {
                occ[j] = false
                res.add(j)
            }
        }
        val result = IntArray(res.size)
        for (i in res.indices) {
            result[i] = res[i]
        }
        return result
    }
}
