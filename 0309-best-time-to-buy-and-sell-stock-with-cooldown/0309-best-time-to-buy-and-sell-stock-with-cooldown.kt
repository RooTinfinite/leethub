class Solution {
    fun maxProfit(prices: IntArray): Int {
        var sell = 0
        var prevSell = 0
        var buy = Int.MIN_VALUE
        var prevBuy: Int
        for (price in prices) {
            prevBuy = buy
            buy = Math.max(prevSell - price, prevBuy)
            prevSell = sell
            sell = Math.max(prevBuy + price, prevSell)
        }
        return sell
    }
}
