class NumArray(nums: IntArray) {
    private val sums: IntArray

    init {
        sums = IntArray(nums.size)
        for (i in nums.indices) {
            if (i == 0) {
                sums[i] = nums[i]
            } else {
                sums[i] = sums[i - 1] + nums[i]
            }
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return if (i == 0) {
            sums[j]
        } else sums[j] - sums[i - 1]
    }
}


/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */