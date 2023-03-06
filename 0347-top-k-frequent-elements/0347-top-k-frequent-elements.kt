class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        nums.sort()
        // Min heap of <number, frequency>
        val queue: Queue<IntArray> = PriorityQueue(k + 1) { a: IntArray, b: IntArray -> a[1] - b[1] }
        // Filter with min heap
        var j = 0
        for (i in 0..nums.size) {
            if (i == nums.size || nums[i] != nums[j]) {
                queue.offer(intArrayOf(nums[j], i - j))
                if (queue.size > k) {
                    queue.poll()
                }
                j = i
            }
        }
        // Convert to int array
        val result = IntArray(k)
        for (i in k - 1 downTo 0) {
            result[i] = queue.poll().get(0)
        }
        return result
    }
}
