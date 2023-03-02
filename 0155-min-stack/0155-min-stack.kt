class MinStack() {
    private val stack: Stack<Pair<Int, Int>> = Stack()

    fun push(x: Int) {
        val min: Int = if (stack.isEmpty()) x
        else getMin()

        stack.push(x to minOf(min, x))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack
            .peek()
            .first
    }

    fun getMin(): Int {
        return stack
            .peek()
            .second
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */