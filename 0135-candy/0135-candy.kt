class Solution {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size)
        Arrays.fill(candies, 1)
        for (i in 0 until ratings.size - 1) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i] + 1
            }
        }
        for (i in ratings.size - 1 downTo 1) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] < candies[i] + 1) {
                candies[i - 1] = candies[i] + 1
            }
        }
        var total = 0
        for (candy in candies) {
            total += candy
        }
        return total
    }
}
