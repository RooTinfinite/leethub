class Solution {
    fun numberOfBoomerangs(points: Array<IntArray>): Int {
        val m: HashMap<Int, Int> = HashMap()
        var ans = 0
        for (i in points.indices) {
            for (j in points.indices) {
                if (i == j) {
                    continue
                }
                val dis = dist(points[i], points[j])
                val prev = m.getOrDefault(dis, 0)
                if (prev >= 1) {
                    ans += prev * 2
                }
                m[dis] = prev + 1
            }
            m.clear()
        }
        return ans
    }

    private fun dist(d1: IntArray, d2: IntArray): Int {
        return (d1[0] - d2[0]) * (d1[0] - d2[0]) + (d1[1] - d2[1]) * (d1[1] - d2[1])
    }
}
