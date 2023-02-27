class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var k = 0
        var count = 0
        while (i < nums.size - 1) {
            ++count
            if (count <= 2) {
                nums[k++] = nums[i]
            }
            if (nums[i] != nums[i + 1]) {
                count = 0
                i++
                continue
            }
            i++
        }
        ++count
        if (count <= 2) {
            nums[k++] = nums[i]
        }
        return k
    }
}
