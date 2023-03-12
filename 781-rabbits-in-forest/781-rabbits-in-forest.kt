class Solution {
    fun numRabbits(answers: IntArray): Int {
        val counts = IntArray(1001)
        for (element in answers) {
            counts[element]++
        }
        var answer = counts[0]
        for (i in 1..1000) {
            if (counts[i] > 0) {
                val rabbitsInPartialGroup = counts[i] % (i + 1)
                val rabbitsInCompleteGroups = counts[i] - rabbitsInPartialGroup
                answer += rabbitsInCompleteGroups
                if (rabbitsInPartialGroup > 0) {
                    answer += i + 1
                }
            }
        }
        return answer
    }
}
