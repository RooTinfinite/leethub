class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1]
            }
        }
        return max
    }
}
