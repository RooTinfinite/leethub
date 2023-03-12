class Solution {
    fun partitionLabels(s: String): List<Int> {
        val letters = s.toCharArray()
        val result: MutableList<Int> = ArrayList()
        val position = IntArray(26)
        for (i in letters.indices) {
            position[letters[i] - 'a'] = i
        }
        var i = 0
        var prev = -1
        var max = 0
        while (i < letters.size) {
            if (position[letters[i] - 'a'] > max) {
                max = position[letters[i] - 'a']
            }
            if (i == max) {
                result.add(i - prev)
                prev = i
            }
            i++
        }
        return result
    }
}
