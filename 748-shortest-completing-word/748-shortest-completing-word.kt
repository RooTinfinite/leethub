class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        var licensePlate = licensePlate
        licensePlate = licensePlate.toLowerCase()
        val a = IntArray(26)
        for (i in licensePlate.indices) {
            if (Character.isLetter(licensePlate[i])) {
                a[licensePlate[i].toInt() - 'a'.toInt()]++
            }
        }
        var ans = ""
        for (str in words) {
            val a1 = IntArray(26)
            for (element in str) {
                a1[element.toInt() - 'a'.toInt()]++
            }
            var j = 0
            while (j < 26) {
                if (a[j] <= a1[j]) {
                    j++
                } else {
                    break
                }
            }
            if (j == 26 && (ans.isEmpty() || ans.length > str.length)) {
                ans = str
            }
        }
        return ans
    }
}
