class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val dist = Array(mat.size) { IntArray(mat[0].size) }
        for (i in mat.indices) {
            dist[i].fill(Int.MAX_VALUE - 100000)
        }
        for (i in mat.indices) {
            for (j in mat[0].indices) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1)
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1)
                    }
                }
            }
        }
        for (i in mat.indices.reversed()) {
            for (j in mat[0].indices.reversed()) {
                if (i < mat.size - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1)
                }
                if (j < mat[0].size - 1) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1)
                }
            }
        }
        return dist
    }
}
