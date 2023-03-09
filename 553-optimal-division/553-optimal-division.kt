class Solution {
    fun optimalDivision(nums: IntArray): String {
        val sb = StringBuilder()
        if (nums.size == 1) {
            sb.append(nums[0])
            return sb.toString()
        }
        if (nums.size == 2) {
            sb.append(nums[0])
            sb.append("/")
            sb.append(nums[1])
            return sb.toString()
        }
        sb.append(nums[0])
        sb.append("/")
        sb.append("(")
        for (i in 1 until nums.size - 1) {
            sb.append(nums[i])
            sb.append('/')
        }
        sb.append(nums[nums.size - 1])
        sb.append(")")
        return sb.toString()
    }
}
