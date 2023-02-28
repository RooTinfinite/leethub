class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val output: MutableList<List<Int>> = ArrayList()
        for (i in 0 until numRows) {
            val currRow: MutableList<Int> = ArrayList()
            for (j in 0..i) {
                if (j == 0 || j == i || i <= 1) {
                    currRow.add(1)
                } else {
                    val currCell = output[i - 1][j - 1] + output[i - 1][j]
                    currRow.add(currCell)
                }
            }
            output.add(currRow)
        }
        return output
    }
}
