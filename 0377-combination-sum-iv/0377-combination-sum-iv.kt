import java.util.Arrays

class Solution {
    private lateinit var storage: IntArray

    fun combinationSum4(nums: IntArray, target: Int): Int {
        storage = IntArray(target + 1)
        Arrays.fill(storage, -1)
        return result(nums, target)
    }

    private fun result(nums: IntArray, target: Int): Int {
        if (target < 0) {
            return 0
        }
        if (target == 0) {
            return 1
        }
        if (storage[target] != -1) {
            return storage[target]
        }
        var count = 0
        for (i in nums) {
            count += result(nums, target - i)
        }
        storage[target] = count
        return count
    }
}
