import java.util.Arrays

class Solution {
    fun largestNumber(nums: IntArray): String {
        val n = nums.size
        val s = arrayOfNulls<String>(n)
        for (i in 0 until n) {
            s[i] = nums[i].toString()
        }
        Arrays.sort(s) { a, b -> (b + a).compareTo(a + b) }
        val sb = StringBuilder()
        for (str in s) {
            sb.append(str)
        }
        val result = sb.toString()
        return if (result.startsWith("0")) "0" else result
    }
}
