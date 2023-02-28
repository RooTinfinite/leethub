import java.util.function.BiFunction

class Solution {
    val op = mapOf<String, BiFunction<Int, Int, Int>>(
        "/" to BiFunction { a, b -> a / b },
        "*" to BiFunction { a, b -> a * b },
        "+" to BiFunction { a, b -> a + b },
        "-" to BiFunction { a, b -> a - b }
    )
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<String>()
        for (t in tokens) {
            if (op.contains(t)) {
                val b = stack.removeFirst().toInt()
                val a = stack.removeFirst().toInt()
                val c = op[t]!!.apply(a, b)
                stack.addFirst(c.toString())
            } else {
                stack.addFirst(t)
            }
        }
        return stack.removeFirst().toInt()
    }
}
