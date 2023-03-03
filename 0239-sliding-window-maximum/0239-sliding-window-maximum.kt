class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val res = IntArray(n - k + 1)
        var x = 0
        val dq = LinkedList<Int>()
        var i = 0
        var j = 0
        while (j < nums.size) {
            while (!dq.isEmpty() && dq.peekLast() < nums[j]) {
                dq.pollLast()
            }
            dq.addLast(nums[j])
            if (j - i + 1 == k) {
                res[x] = dq.peekFirst()
                ++x
                if (dq.peekFirst() == nums[i]) {
                    dq.pollFirst()
                }
                ++i
            }
            ++j
        }
        return res
    }
}
