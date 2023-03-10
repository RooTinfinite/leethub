class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var n = n
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 0 && n > 0) {
                val left = i == 0 || flowerbed[i - 1] == 0
                val right = i == flowerbed.size - 1 || flowerbed[i + 1] == 0
                if (left && right) {
                    flowerbed[i] = 1
                    n--
                }
            }
            if (n == 0) {
                break
            }
        }
        return n == 0
    }
}
