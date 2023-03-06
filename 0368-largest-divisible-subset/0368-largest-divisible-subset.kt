class Solution {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val n = nums.size
        val count = IntArray(n)
        val pre = IntArray(n)
        nums.sort()
        var max = 0
        var index = -1
        for (i in 0 until n) {
            count[i] = 1
            pre[i] = -1
            for (j in i - 1 downTo 0) {
                if (nums[i] % nums[j] == 0 && 1 + count[j] > count[i]) {
                    count[i] = count[j] + 1
                    pre[i] = j
                }
            }
            if (count[i] > max) {
                max = count[i]
                index = i
            }
        }
        val res: MutableList<Int> = ArrayList()
        while (index != -1) {
            res.add(nums[index])
            index = pre[index]
        }
        return res
    }
}
