class Solution {
    fun findRelativeRanks(score: IntArray): Array<String> {
        fun mapPlace(score: Int, sortedScores: IntArray): String {
            val place = sortedScores.lastIndex - sortedScores.binarySearch(score)
            return when {
                place > 2 -> "${place + 1}"
                place == 0 -> "Gold Medal"
                place == 1 -> "Silver Medal"
                place == 2 -> "Bronze Medal"
                else -> throw NoWhenBranchMatchedException()
            }
        }

        val sortedScores = score.clone().apply { sort() }
        return score.map { mapPlace(it, sortedScores) }.toTypedArray()
    }
}
