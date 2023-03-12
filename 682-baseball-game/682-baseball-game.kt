class Solution {
    fun calPoints(ops: Array<String>): Int {
        val resultList: MutableList<Int> = ArrayList(ops.size)
        for (op in ops) {
            val size = resultList.size
            if ("C" == op) {
                resultList.removeAt(size - 1)
            } else if ("D" == op) {
                resultList.add(resultList[size - 1] * 2)
            } else if ("+" == op) {
                resultList.add(resultList[size - 1] + resultList[size - 2])
            } else {
                resultList.add(op.toInt())
            }
        }
        return resultList.stream().reduce(0) { a: Int, b: Int -> Integer.sum(a, b) }
    }
}
