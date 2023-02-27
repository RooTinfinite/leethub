class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val res: MutableList<List<Int>> = ArrayList()
        solve(nums, ArrayList(), res, 0)
        return res
    }

    private fun solve(nums: IntArray, temp: MutableList<Int>, res: MutableList<List<Int>>, start: Int) {
        res.add(ArrayList(temp))
        for (i in start until nums.size) {
            temp.add(nums[i])
            solve(nums, temp, res, i + 1)
            temp.removeAt(temp.size - 1)
        }
    }
}
