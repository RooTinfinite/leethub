class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        val res = IntArray(2)
        var i = 0
        var j = numbers.size - 1
        while (i < j) {
            val sum = numbers[i] + numbers[j]
            if (sum == target) {
                res[0] = i + 1
                res[1] = j + 1
                return res
            } else if (sum < target) {
                i++
            } else {
                j--
            }
        }
        return res
    }
}
