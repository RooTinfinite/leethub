class MyQueue() {
    private val deque: Deque<Int> = LinkedList()

    fun push(x: Int) {
        deque.add(x)
    }

    fun pop(): Int = deque.removeFirst()

    fun peek(): Int = deque.first()

    fun empty(): Boolean = deque.isEmpty()
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */