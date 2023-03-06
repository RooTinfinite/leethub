class Solution {
    fun minPatches(nums: IntArray, n: Int): Int {
        var res = 0
        var sum: Long = 0
        var i = 0
        while (sum < n) {
            // required number
            val req = sum + 1
            if (i < nums.size && nums[i] <= req) {
                sum += nums[i++].toLong()
            } else {
                sum += req
                res++
            }
        }
        return res
    }
}
