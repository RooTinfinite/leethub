class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val queue = PriorityQueue<Int>()
        nums.forEach {
            queue.add(it)
        }
        var lastNum = Integer.MIN_VALUE
        var length = 0
        var maxLength = 1
        while (!queue.isEmpty()) {
            val num = queue.poll()
            if (num == lastNum) {
                continue
            }
            length ++
            if (num - lastNum > 1) {
                length = 1
            }
            lastNum = num
            maxLength = maxOf(maxLength, length)
        }
        return maxLength
    }
}
