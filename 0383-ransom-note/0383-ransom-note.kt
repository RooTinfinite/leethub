class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val a = IntArray(26)
        var n = ransomNote.length
        for (i in 0 until n) {
            a[ransomNote[i].toInt() - 97]++
        }
        var i = 0
        while (i < magazine.length && n != 0) {
            if (a[magazine[i].toInt() - 97] > 0) {
                n--
                a[magazine[i].toInt() - 97]--
            }
            i++
        }
        return n == 0
    }
}
