class Solution {
    private var ans: MutableList<List<Int>>? = null
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        ans = ArrayList()
        permute(nums, 0)
        return ans as ArrayList<List<Int>>
    }

    private fun permute(nums: IntArray, p: Int) {
        if (p >= nums.size - 1) {
            val t: MutableList<Int> = ArrayList(nums.size)
            for (n in nums) {
                t.add(n)
            }
            ans!!.add(t)
            return
        }
        permute(nums, p + 1)
        val used = BooleanArray(30)
        for (i in p + 1 until nums.size) {
            if (nums[i] != nums[p] && !used[10 + nums[i]]) {
                used[10 + nums[i]] = true
                swap(nums, p, i)
                permute(nums, p + 1)
                swap(nums, p, i)
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
    }
}
