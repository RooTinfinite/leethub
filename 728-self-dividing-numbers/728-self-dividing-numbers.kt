class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val list: MutableList<Int> = ArrayList()
        for (i in left..right) {
            if (isSelfDividing(i)) {
                list.add(i)
            }
        }
        return list
    }

    private fun isSelfDividing(value: Int): Boolean {
        var value = value
        val origin = value
        while (value != 0) {
            val digit = value % 10
            value /= 10
            if (digit == 0 || origin % digit != 0) {
                return false
            }
        }
        return true
    }
}
