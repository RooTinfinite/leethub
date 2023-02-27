class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list: MutableList<Int> = ArrayList()
        var r = 0
        var c = 0
        var bigR = matrix.size - 1
        var bigC: Int = matrix[0].size - 1
        while (r <= bigR && c <= bigC) {
            for (i in c..bigC) {
                list.add(matrix[r][i])
            }
            r++
            for (i in r..bigR) {
                list.add(matrix[i][bigC])
            }
            bigC--
            run {
                var i = bigC
                while (i >= c && r <= bigR) {
                    list.add(matrix[bigR][i])
                    i--
                }
            }
            bigR--
            var i = bigR
            while (i >= r && c <= bigC) {
                list.add(matrix[i][c])
                i--
            }
            c++
        }
        return list
    }
}
