class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val len = nums.size
        val result: MutableList<List<Int>> = ArrayList()
        var l: Int
        var r: Int
        var i = 0
        while (i < len - 2) {
            l = i + 1
            r = len - 1
            while (r > l) {
                val sum = nums[i] + nums[l] + nums[r]
                if (sum < 0) {
                    l++
                } else if (sum > 0) {
                    r--
                } else {
                    val list: MutableList<Int> = ArrayList()
                    list.add(nums[i])
                    list.add(nums[l])
                    list.add(nums[r])
                    result.add(list)
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++
                    }
                    while (r > l && nums[r - 1] == nums[r]) {
                        r--
                    }
                    l++
                    r--
                }
            }
            while (i < len - 1 && nums[i + 1] == nums[i]) {
                i++
            }
            i++
        }
        return result
    }
}
