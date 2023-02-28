class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            if (prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i] - min)
            } else {
                min = prices[i]
            }
        }
        return maxProfit
    }
}
