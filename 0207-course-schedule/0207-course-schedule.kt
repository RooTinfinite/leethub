class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj: Array<ArrayList<Int>?> = arrayOfNulls<ArrayList<Int>>(numCourses)
        for (i in 0 until numCourses) {
            adj[i] = ArrayList()
        }
        for (pre in prerequisites) {
            adj[pre[1]]?.add(pre[0])
        }
        val colors = IntArray(numCourses)
        for (i in 0 until numCourses) {
            if (colors[i] == WHITE && !adj[i]?.isEmpty()!! && hasCycle(adj, i, colors)) {
                return false
            }
        }
        return true
    }

    private fun hasCycle(adj: Array<ArrayList<Int>?>, node: Int, colors: IntArray): Boolean {
        colors[node] = GRAY
        for (nei in adj[node]!!) {
            if (colors[nei] == GRAY) {
                return true
            }
            if (colors[nei] == WHITE && hasCycle(adj, nei, colors)) {
                return true
            }
        }
        colors[node] = BLACK
        return false
    }

    companion object {
        private const val WHITE = 0
        private const val GRAY = 1
        private const val BLACK = 2
    }
}
