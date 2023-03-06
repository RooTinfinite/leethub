import kotlin.random.Random

@Suppress("kotlin:S2245")
class Solution(private val nums: IntArray) {
    // Resets the array to its original configuration and return it.
    fun reset(): IntArray {
        return nums
    }

    // Returns a random shuffling of the array.
    fun shuffle(): IntArray {
        val shuffled = nums.clone()
        for (i in nums.size - 1 downTo 1) {
            val j: Int = Random.nextInt(i + 1)
            swap(shuffled, i, j)
        }
        return shuffled
    }

    private fun swap(shuffled: IntArray, i: Int, j: Int) {
        val tmp = shuffled[i]
        shuffled[i] = shuffled[j]
        shuffled[j] = tmp
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */