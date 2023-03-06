import kotlin.random.Random

@Suppress("kotlin:S2245")
class Solution(nums: IntArray) {
    // O(n) time | O(n) space
    private val map: MutableMap<Int, MutableList<Int>>

    init {
        map = HashMap()
        for (i in nums.indices) {
            map.computeIfAbsent(
                nums[i]
            ) { ArrayList() }.add(i)
        }
    }

    fun pick(target: Int): Int {
        val list: List<Int> = map[target]!!
        return list[Random.nextInt(list.size)]
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(nums)
 * var param_1 = obj.pick(target)
 */