class Solution {
    fun findCircleNum(arr: Array<IntArray>): Int {
        val parent = IntArray(arr.size)
        parent.fill(-1)
        var ans = 0
        for (i in 0 until arr.size - 1) {
            for (j in i + 1 until arr[i].size) {
                if (arr[i][j] == 1) {
                    ans += union(i, j, parent)
                }
            }
        }
        return arr.size - ans
    }

    private fun union(a: Int, b: Int, arr: IntArray): Int {
        val ga = find(a, arr)
        val gb = find(b, arr)
        if (ga != gb) {
            arr[gb] = ga
            return 1
        }
        return 0
    }

    private fun find(a: Int, arr: IntArray): Int {
        if (arr[a] == -1) {
            return a
        }
        arr[a] = find(arr[a], arr)
        return arr[a]
    }
}
