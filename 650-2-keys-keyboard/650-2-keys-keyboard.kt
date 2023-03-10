class Solution {
    fun minSteps(n: Int): Int {
        var count = 1
        var cost = 0
        var addValue = 1
        while (count < n) {
            cost++
            count += addValue
            if (n % count == 0) {
                cost++
                addValue = count
            }
        }
        return cost
    }
}
