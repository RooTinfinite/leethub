import java.util.Deque
import java.util.LinkedList

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack: Deque<Int> = LinkedList()
        for (a in asteroids) {
            if (a > 0) {
                stack.addLast(a)
            } else {
                if (!stack.isEmpty() && stack.peekLast() > 0) {
                    if (stack.peekLast() == Math.abs(a)) {
                        stack.pollLast()
                    } else {
                        while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < Math.abs(a)) {
                            stack.pollLast()
                        }
                        if (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() == Math.abs(a)) {
                            stack.pollLast()
                        } else if (stack.isEmpty() || stack.peekLast() < 0) {
                            stack.addLast(a)
                        }
                    }
                } else {
                    stack.addLast(a)
                }
            }
        }
        val ans = IntArray(stack.size)
        for (i in stack.indices.reversed()) {
            ans[i] = stack.pollLast()
        }
        return ans
    }
}
