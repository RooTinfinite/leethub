class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var sumGas = 0
        var sumCost = 0
        var curGas = 0
        var result = -1
        for (i in gas.indices) {
            curGas += gas[i] - cost[i]
            // re-calculate the starting point
            if (curGas < 0) {
                result = -1
                curGas = 0
            } else if (result == -1) {
                // set initial starting point
                result = i
            }
            sumGas += gas[i]
            sumCost += cost[i]
        }
        return if (sumGas < sumCost) {
            -1
        } else result
    }
}
