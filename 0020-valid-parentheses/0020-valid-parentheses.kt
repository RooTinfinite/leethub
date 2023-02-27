class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (element in s) {
            val c = element
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c)
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop()
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop()
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop()
            } else {
                return false
            }
        }
        return stack.isEmpty()
    }
}
