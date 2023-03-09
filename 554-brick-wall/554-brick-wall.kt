class Solution {
    fun leastBricks(wall: List<List<Int>>): Int {
        val gapMap = mutableMapOf<Int, Int>()

        wall.forEach { row ->
            var pos = 0
            for (brickId in 0 until row.lastIndex) {
                pos += row[brickId]
                gapMap[pos] = gapMap.getOrDefault(pos, 0) + 1
            }
        }
        var value = 0

        if (gapMap.size > 0) {
            value = gapMap.values.max()!!
        }
        return wall.size - value
    }
}
