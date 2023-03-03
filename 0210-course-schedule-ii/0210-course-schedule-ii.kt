class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indegrees = IntArray(numCourses) { 0 }
        val graph = buildGraph(numCourses, prerequisites, indegrees)
        val queue = ArrayDeque<Int>()
        for ((idx, indegree) in indegrees.withIndex()) {
            if (indegree == 0) {
                queue.addLast(idx)
            }
        }
        val ans = IntArray(numCourses) { 0 }
        var idx = 0
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            ans[idx++] = cur
            for (pre in graph[cur]) {
                if (--indegrees[pre] == 0) {
                    queue.addLast(pre)
                }
            }
        }
        if (idx < numCourses) {
            return intArrayOf()
        }
        return ans
    }

    private fun buildGraph(
        numCourses: Int,
        prerequisites: Array<IntArray>,
        indegrees: IntArray
    ): List<List<Int>> {
        val graph = List(numCourses) { mutableListOf<Int>() }
        for ((cur, prev) in prerequisites) {
            graph[prev].add(cur)
            ++indegrees[cur]
        }
        return graph
    }
}
