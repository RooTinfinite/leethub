import java.util.PriorityQueue

class MedianFinder {
    // take two queues one is for storing upper half and the other is for lowerhalf
    // max stores the lower half
    // min heap stores the upper half
    private val maxHeap: PriorityQueue<Int> = PriorityQueue { a: Int, b: Int -> b - a }
    private val minHeap: PriorityQueue<Int> = PriorityQueue()
    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }
        if (Math.abs(maxHeap.size - minHeap.size) > 1) {
            balance(maxHeap, minHeap)
        }
    }

    fun balance(maxHeap: PriorityQueue<Int>, minHeap: PriorityQueue<Int>) {
        val large = if (maxHeap.size > minHeap.size) maxHeap else minHeap
        val small = if (maxHeap.size > minHeap.size) minHeap else maxHeap
        small.offer(large.poll())
    }

    fun findMedian(): Double {
        val large = if (maxHeap.size > minHeap.size) maxHeap else minHeap
        val small = if (maxHeap.size > minHeap.size) minHeap else maxHeap
        return if (large.size == small.size) {
            (large.peek() + small.peek()).toDouble() / 2
        } else {
            large.peek().toDouble()
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */