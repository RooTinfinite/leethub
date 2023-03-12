import java.util.PriorityQueue

class KthLargest(private val maxSize: Int, nums: IntArray) {
    private val heap: PriorityQueue<Int> = PriorityQueue()

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun add(`val`: Int): Int {
        if (heap.size < maxSize) {
            heap.add(`val`)
        } else if (heap.peek() < `val`) {
            heap.add(`val`)
            heap.poll()
        }
        return heap.peek()
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */