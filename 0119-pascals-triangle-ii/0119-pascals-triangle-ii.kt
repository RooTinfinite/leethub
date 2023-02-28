class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val buffer = IntArray(rowIndex + 1)
        buffer[0] = 1
        computeRow(buffer, 1)
        // Copy buffer to List of Integer.
        val ans: MutableList<Int> = ArrayList(buffer.size)
        for (j in buffer) {
            ans.add(j)
        }
        return ans
    }

    private fun computeRow(buffer: IntArray, k: Int) {
        if (k >= buffer.size) {
            return
        }
        var previous = buffer[0]
        for (i in 1 until k) {
            val tmp = previous + buffer[i]
            previous = buffer[i]
            buffer[i] = tmp
        }
        buffer[k] = 1
        computeRow(buffer, k + 1)
    }
}
