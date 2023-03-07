import java.util.Arrays

class Solution {
    /*
     * I'm glad to have come up with this solution on my own on 10/13/2021:
     * we'll have to sort the
     * balloons by its ending points, a counter case to this is below:
     * {{0, 6}, {0, 9}, {7, 8}}
     * if we sort by starting points, then it becomes:
     * {0, 6}, {0, 9}, {7, 8}
     * this way, if we shoot 9,
     * {0, 6} won't be burst however, if we sort by ending points, then it becomes:
     * {0, 6}, {7, 8}, {0, 9}, then we shoot at 6, then at 8, this gives us the result of bursting all balloons.
     */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        Arrays.sort(
            points
        ) { a: IntArray, b: IntArray ->
            Integer.compare(
                a[1],
                b[1]
            )
        }
        var minArrows = 1
        var end = points[0][1].toLong()
        for (i in 1 until points.size) {
            if (points[i][0] > end) {
                minArrows++
                end = points[i][1].toLong()
            }
        }
        return minArrows
    }
}
