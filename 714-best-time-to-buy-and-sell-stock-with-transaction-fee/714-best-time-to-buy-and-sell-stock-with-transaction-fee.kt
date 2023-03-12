class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var cash = 0
        var hold = -prices[0]
        for (i in 1 until prices.size) {
            cash = cash.coerceAtLeast(hold + prices[i] - fee)
            hold = hold.coerceAtLeast(cash - prices[i])
        }
        return cash
    }
}
