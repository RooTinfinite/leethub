import java.util.Deque
import java.util.LinkedList

class Solution {
    /*
     * It scans only once, this is the power of using correct data structure.
     * It goes from the right to the left.
     * It keeps pushing elements into the stack,
     * but it also keeps poping elements out of the stack as long as the current element is bigger than this number.
     */
    fun find132pattern(nums: IntArray): Boolean {
        val stack: Deque<Int> = LinkedList()
        var s3 = Int.MIN_VALUE
        for (i in nums.indices.reversed()) {
            if (nums[i] < s3) {
                return true
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    s3 = Math.max(s3, stack.pop())
                }
            }
            stack.push(nums[i])
        }
        return false
    }
}
