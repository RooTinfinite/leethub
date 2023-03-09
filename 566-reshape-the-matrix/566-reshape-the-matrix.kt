class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (mat.size * mat[0].size != r * c) {
            return mat
        }
        var p = 0
        val flatArr = IntArray(mat.size * mat[0].size)
        for (ints in mat) {
            for (anInt in ints) {
                flatArr[p++] = anInt
            }
        }
        val ansMat = Array(r) { IntArray(c) }
        var k = 0
        for (i in ansMat.indices) {
            for (j in ansMat[i].indices) {
                ansMat[i][j] = flatArr[k++]
            }
        }
        return ansMat
    }
}
