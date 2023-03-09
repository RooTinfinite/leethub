import java.util.ArrayDeque
import java.util.Deque

class Solution {
    fun nextGreaterElements(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val stack: Deque<Int> = ArrayDeque()
        for (i in nums.size * 2 - 1 downTo 0) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % nums.size]) {
                stack.pop()
            }
            result[i % nums.size] = if (stack.isEmpty()) -1 else nums[stack.peek()]
            stack.push(i % nums.size)
        }
        return result
    }
}
