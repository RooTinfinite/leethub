class Solution {
    var allComb: MutableList<List<Int>> = ArrayList()
    var comb: MutableList<Int> = ArrayList()
    lateinit var nums: IntArray
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        this.nums = nums
        dfs(0)
        allComb.add(ArrayList())
        return allComb
    }

    private fun dfs(start: Int) {
        if (start > nums.size) {
            return
        }
        for (i in start until nums.size) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue
            }
            comb.add(nums[i])
            allComb.add(ArrayList(comb))
            dfs(i + 1)
            comb.removeAt(comb.size - 1)
        }
    }
}
