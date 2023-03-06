class Solution {
    fun wiggleSort(nums: IntArray) {
        nums.sort()
        val result = IntArray(nums.size)
        var index = nums.size - 1
        var i = 1
        // Start filling all peaks (which is all at odd indexes) from start
        while (i < nums.size) {
            result[i] = nums[index]
            --index
            i += 2
        }
        // Start filling all valleys (which is all at even indexes) from end
        // why from end, as the last peak index may have smallest largest value, so to
        // make sure, that is also '>', fill in the smallest element near it.
        i = if ((nums.size - 1) % 2 == 0) nums.size - 1 else nums.size - 2
        index = 0
        while (i >= 0) {
            result[i] = nums[index]
            ++index
            i -= 2
        }
        System.arraycopy(result, 0, nums, 0, nums.size)
    }
}
