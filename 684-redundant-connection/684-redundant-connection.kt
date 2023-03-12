class Solution {
    private lateinit var par: IntArray
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val ans = IntArray(2)
        val n = edges.size
        par = IntArray(n + 1)
        for (i in 0 until n) {
            par[i] = i
        }
        for (edge in edges) {
            val lx = find(edge[0])
            val ly = find(edge[1])
            if (lx != ly) {
                par[lx] = ly
            } else {
                ans[0] = edge[0]
                ans[1] = edge[1]
            }
        }
        return ans
    }

    private fun find(x: Int): Int {
        return if (par[x] == x) {
            x
        } else find(par[x])
    }
}
