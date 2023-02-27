class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val indexMap: MutableMap<Int, Int> = HashMap()
        for (i in numbers.indices) {
            val requiredNum = target - numbers[i]
            if (indexMap.containsKey(requiredNum)) {
                return intArrayOf(indexMap[requiredNum]!!, i)
            }
            indexMap[numbers[i]] = i
        }
        return intArrayOf(-1, -1)
    }
}
