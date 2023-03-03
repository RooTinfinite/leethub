class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set: MutableSet<Int> = HashSet()
        for (n in nums) {
            if (set.contains(n)) {
                return true
            }
            set.add(n)
        }
        return false
    }
}
