class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backtrack(start: Int, case: MutableList<Int>, sum: Int) {
            if (sum >= target) {
                if (sum == target) {
                    result.add(case.toList())
                }
                return
            }
            for (i in start until candidates.size) {
                case.add(candidates[i])
                backtrack(i, case, sum + candidates[i])
                case.removeAt(case.size - 1)
            }
        }
        backtrack(0, mutableListOf(), 0)
        return result
    }
}
