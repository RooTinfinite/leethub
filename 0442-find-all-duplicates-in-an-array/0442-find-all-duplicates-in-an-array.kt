class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val setToCheck: MutableSet<Int> = mutableSetOf()
        val duplicates: MutableList<Int> = mutableListOf()
        nums.forEach { element ->
            if (!setToCheck.add(element)) {
                duplicates.add(element)
            }
        }
        return duplicates
    }
}
