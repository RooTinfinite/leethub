class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val sol = IntArray(temperatures.size)
        sol[temperatures.size - 1] = 0
        for (i in sol.size - 2 downTo 0) {
            var j = i + 1
            while (j <= sol.size) {
                if (temperatures[i] < temperatures[j]) {
                    sol[i] = j - i
                    break
                } else {
                    if (sol[j] == 0) {
                        break
                    }
                    j = j + sol[j]
                }
            }
        }
        return sol
    }
}
