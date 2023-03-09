class Solution {
    fun distributeCandies(candyType: IntArray): Int {
        val s: MutableSet<Int> = HashSet()
        for (i in candyType) {
            if (!s.contains(i)) {
                s.add(i)
            }
        }
        val canEat = candyType.size / 2
        return if (s.size >= canEat) {
            canEat
        } else {
            s.size
        }
    }
}
