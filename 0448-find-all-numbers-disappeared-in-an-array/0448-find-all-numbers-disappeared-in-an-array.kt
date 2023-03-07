class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val arr = IntArray(nums.size)
        var counter = 0
        for (i in nums.indices) {
            arr[nums[counter] - 1] = 1
            counter++
        }
        val res: MutableList<Int> = ArrayList()
        for (i in arr.indices) {
            if (arr[i] == 0) {
                res.add(i + 1)
            }
        }
        return res
    }
}
