class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return ArrayList()
        }
        val finalResult: MutableList<List<Int>> = ArrayList()
        permuteRecur(nums, finalResult, ArrayList(), BooleanArray(nums.size))
        return finalResult
    }

    private fun permuteRecur(
        nums: IntArray,
        finalResult: MutableList<List<Int>>,
        currResult: MutableList<Int>,
        used: BooleanArray
    ) {
        if (currResult.size == nums.size) {
            finalResult.add(ArrayList(currResult))
            return
        }
        for (i in nums.indices) {
            if (used[i]) {
                continue
            }
            currResult.add(nums[i])
            used[i] = true
            permuteRecur(nums, finalResult, currResult, used)
            used[i] = false
            currResult.removeAt(currResult.size - 1)
        }
    }
}
